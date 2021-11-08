package by.it.academy.example.dao;


import by.it.academy.example.entity.CommandsSQL;
import by.it.academy.example.entity.UserInformationJDBC;
import by.it.academy.example.entity.TestDaoListTestDbParameter;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Component
public class JdbcTestDbDaoImpl implements JdbcTestDbDAO{
    private Connection connection;

    public void openConnection() {
        UserInformationJDBC uInfo = new UserInformationJDBC();
        connection = uInfo.getPoolConnection();
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int save(CommandsSQL id) throws SQLException {
        connection.setAutoCommit(false);
        String sql = id.getInsert();
        try (Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate(sql);
            connection.commit();
            return 1;
        } catch (Exception e) {
            connection.rollback();
            return 0;
        }finally {
            connection.setAutoCommit(true);
        }

    }

    @Override
    public int get(CommandsSQL id) throws SQLException {
        String sql = id.getSelect();
        try (Statement statement = connection.createStatement()) {
            ResultSet count = statement.executeQuery(sql);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int update(CommandsSQL id) throws SQLException {
        String sql = id.getUpdate();
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql);

        }
    }

    @Override
    public int delete(CommandsSQL id) throws SQLException {
        String sql = id.getDelete();
        try (Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate(sql);
            if (count != 1) {
                return count;
            } else {
                return count;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<String> getAllTestDbParameter(CommandsSQL id) throws SQLException {
        LinkedList lst = new LinkedList();
        try (PreparedStatement ps = connection.prepareStatement(id.getSelect())){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TestDaoListTestDbParameter user = new TestDaoListTestDbParameter();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setNumber(rs.getInt(3));
                lst.add(String.valueOf(user));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lst;
    }

    @Override
    public int getOneByTwo(CommandsSQL id) throws SQLException {
        String sql = id.getJoin();
        try (Statement statement = connection.createStatement()) {
            ResultSet count = statement.executeQuery(sql);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
