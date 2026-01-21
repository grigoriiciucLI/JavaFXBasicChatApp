package Repository.Db;

import Domain.Event.Notification;
import Domain.User.User;

import java.sql.*;
import java.time.LocalDateTime;

public class NotificationRepository extends DbRepository<Integer, Notification> {
    private final PersonRepository personRepository;

    public NotificationRepository(Connection conn, PersonRepository personRepository) {
        super(conn);
        this.personRepository = personRepository;
    }

    @Override
    protected String buildInsertSql() {
        return "INSERT INTO notifications (receiver_id, content, generated_on) VALUES (?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement ps, Notification n) throws SQLException {
        ps.setLong(1, n.getReceiver().getId());
        ps.setString(2, n.getContent());
        ps.setTimestamp(3, Timestamp.valueOf(n.getGeneratedOn()));
    }

    @Override
    protected String buildUpdateSql() {
        return "UPDATE notifications SET receiver_id = ?, content = ?, generated_on = ?, seen_on = ? WHERE id = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement ps, Notification n) throws SQLException {
        ps.setLong(1, n.getReceiver().getId());
        ps.setString(2, n.getContent());
        ps.setTimestamp(3, Timestamp.valueOf(n.getGeneratedOn()));
        ps.setTimestamp(4, Timestamp.valueOf(n.getSeenOn()));
        ps.setInt(5, n.getId());
    }

    @Override
    public String getTableName() {
        return "notifications";
    }

    @Override
    protected Notification mapResultSetToEntity(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("id");
        User receiver = personRepository.findById(rs.getLong("receiver_id")).orElseThrow();
        String content = rs.getString("content");
        LocalDateTime generatedOn = rs.getTimestamp("generated_on").toLocalDateTime();
        Timestamp seenTs = rs.getTimestamp("seen_on");
        LocalDateTime seenOn = seenTs != null ? seenTs.toLocalDateTime() : null;
        return new Notification(id, receiver, content, generatedOn, seenOn);
    }
}
