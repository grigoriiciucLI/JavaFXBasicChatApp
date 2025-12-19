package Domain.User;

import java.nio.channels.FileLock;
import java.util.Objects;

public class Duck extends User{
    private DuckType duckType;
    private double speed;
    private double resistance;
    Flock flock;

    public Duck(Long id, String username, String email, String passwd, DuckType duckType, double speed, double resistance, Flock flock) {
        super(id, username, email, passwd);
        this.duckType = duckType;
        this.speed = speed;
        this.resistance = resistance;
        this.flock = flock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Duck duck = (Duck) o;
        return Double.compare(speed, duck.speed) == 0 && Double.compare(resistance, duck.resistance) == 0 && duckType == duck.duckType && Objects.equals(flock, duck.flock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duckType, speed, resistance, flock);
    }
}
;

