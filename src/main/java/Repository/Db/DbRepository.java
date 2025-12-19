package Repository.Db;

import Domain.Entity;
import Domain.Filter;
import Repository.IRepository;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class DbRepository<ID,E extends Entity<ID>> implements IRepository<ID, E> {
    Connection conn;

    public DbRepository(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }


    public List<E> filter(Filter filter){
        List<E> entities = new ArrayList<>();
        String where = filter.buildWhere();
        String sql = "SELECT * FROM " + getTableName();
        sql += " " + where;
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            filter.applyParameters(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                E entity = mapResultSetToEntity(resultSet);
                entities.add(entity);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);}
        return entities;
    }
    @Override

    public List<E> getAll() {
        List<E> entities = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                E entity = mapResultSetToEntity(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }
    public abstract String getTableName();
    protected abstract E mapResultSetToEntity(ResultSet resultSet);
    public Optional<E> remove(ID id){
        String sql = "DELETE FROM " + getTableName() + " WHERE id = ?";
        Optional<E> entity = findById(id);
        try(var ps = conn.prepareStatement(sql)){
            ps.setObject(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return Optional.of(mapResultSetToEntity(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}