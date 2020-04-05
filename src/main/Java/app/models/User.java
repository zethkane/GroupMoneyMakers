package app.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String password;

    @OneToMany (cascade = CascadeType.ALL)
    private Set<Checking> savingAccounts;

    @OneToMany (cascade = CascadeType.ALL)
    private Set<Saving> checkingAccounts;

    public User(){}

    public User(String name, String password){
        this.name = name;
        this.password = password;
        checkingAccounts = new HashSet<>();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Checking> getSavingAccounts() {
        return savingAccounts;
    }

    public void setSavingAccounts(Set<Checking> savingAccounts) {
        this.savingAccounts = savingAccounts;
    }

    public Set<Saving> getCheckingAccounts() {
        return checkingAccounts;
    }

    public void setCheckingAccounts(Set<Saving> checkingAccounts) {
        this.checkingAccounts = checkingAccounts;
    }
}
