package dao;

import Servlets.LoginServlet;
import org.apache.log4j.Logger;
import pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


public class MySqlUserDao extends MySqlDao implements UserDao {
    static Logger log = Logger.getLogger(MySqlUserDao.class);

    @Override
    public void create(User user) {
        PreparedStatement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement("INSERT INTO users " + "(username, password, role, firstname, lastname)"
                    + "VALUES(?,?,?,?,?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getFirstname());
            stmt.setString(5, user.getLastname());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public User read(int key) {
        String sql = "SELECT * FROM users WHERE id = ?";
        User s = null;
        PreparedStatement stm = null;
        Connection con = getConnection();
        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, key);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                UserTypes e = UserTypes.valueOf(rs.getString("role"));
                switch (e) {
                    case ADMIN:
                        s = new Admin();
                        break;
                    case MEMBER:
                        s = new Member();
                        break;
                    case MODERATOR:
                        s = new Moderator();
                        break;
                    //default:
                    //    s = new User();
                    //    break;
                }
                s.setDatabaseId(rs.getInt("id"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setFirstname(rs.getString("firstname"));
                s.setLastname(rs.getString("lastname"));
                s.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return s;
    }

    @Override
    public void update(User user) {
        PreparedStatement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement("UPDATE users SET username =  ?, password=?, role=?, firstname=?, lastname=?" +
                    "WHERE id =  ?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getFirstname());
            stmt.setString(5, user.getLastname());
            stmt.setInt(6, user.getDatabaseId());

            stmt.execute();
            log.debug("Addition to notes by user ");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Addition of new comment failed " + e.getLocalizedMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

//    @Override
//    public void updateVote(User user, AverageCountPair vote) {
//        Connection con = getConnection();
//        PreparedStatement stmt = null;
//        try {
//            stmt = con.prepareStatement("UPDATE users SET vote =  ?, vote_count=? " +
//                    " WHERE id =  ?");
//            stmt.setFloat(1, vote.getAverage());
//            stmt.setInt(2, vote.getCount());
//            stmt.setInt(3, user.getDatabaseId());
//            stmt.execute();
//            stmt.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//                stmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void delete(User user) {
        PreparedStatement stmt = null;
        Connection con = getConnection();
        try {
            stmt = con.prepareStatement("DELETE FROM users WHERE id =  ?");
            stmt.setInt(1, user.getDatabaseId());

            stmt.execute();
            log.debug("Addition to notes by user ");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Addition of new comment failed " + e.getLocalizedMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        List<User> list = new ArrayList<User>();
        PreparedStatement stm = null;
        Connection con = getConnection();
        try {
            stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            User s = null;
            while (rs.next()
                    ) {
                UserTypes e = UserTypes.valueOf(rs.getString("role"));
                switch (e) {
                    case ADMIN:
                        s = new Admin();
                        break;
                    case MODERATOR:
                        s = new Moderator();
                        break;
                    case MEMBER:
                        s = new Member();
                        break;
                }

                s.setDatabaseId(rs.getInt("id"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setFirstname(rs.getString("firstname"));
                s.setLastname(rs.getString("lastname"));
                s.setRole(rs.getString("role"));
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    @Override
    public User read(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? and password = ?";
        User s = null;
        PreparedStatement stm = null;
        Connection con = getConnection();
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                UserTypes e = UserTypes.valueOf(rs.getString("role"));
                switch (e) {
                    case ADMIN:
                        log.info(username +" role - Admin");
                        s = new Admin();
                        break;
                    case MEMBER:
                        log.info(username + " role - Member");
                        s = new Member();
                        break;
                    case MODERATOR:
                        log.info(username + " role - Moderator");
                        s = new Moderator();
                        break;

                    //default:
                    //    s = new User();
                    //    break;
                }


                s.setDatabaseId(rs.getInt("id"));
                s.setUsername(rs.getString("username"));
                s.setFirstname(rs.getString("firstname"));
                s.setLastname(rs.getString("lastname"));
                s.setPassword(rs.getString("password"));
                s.setRole(rs.getString("role"));
            } else {
                s = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return s;
    }

    @Override
    public User read(String login) {
        String sql = "SELECT * FROM users WHERE username = ?";
        User s = null;
        PreparedStatement stm = null;
        Connection con = getConnection();
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                UserTypes e = UserTypes.valueOf(rs.getString("role"));
                switch (e) {
                    case ADMIN:
                        s = new Admin();
                        break;
                    case MEMBER:
                        s = new Member();
                        break;
                    case MODERATOR:
                        s = new Moderator();
                        break;
                    //default:
                    //    s = new User();
                    //    break;
                }

                s.setDatabaseId(rs.getInt("id"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setFirstname(rs.getString("firstname"));
                s.setLastname(rs.getString("lastname"));
                s.setRole(rs.getString("role"));
            } else {
                s = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return s;
    }
}
