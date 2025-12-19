package Domain.User;

import Domain.Entity;

import java.util.List;

public class Flock<T extends Duck> extends Entity<Integer> {
    private String name;
    private List<T> members;

    public Flock(Integer integer, String name) {
        super(integer);
        this.name = name;
    }
    public void addMember(T d){
        members.add(d);
    }
    public void removeMember(T d){
        members.remove(d);
    }

}
