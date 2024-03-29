package ca.gbc.comp3095.gbccomp3095assignment1.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String account;
    private String password;
    private String email;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Set<Recipe> recipes = new HashSet<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Set<Favorite> favorites = new HashSet<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Set<Meal> meals = new HashSet<>();



    public User(){
    }

    public User(String firstName, String lastName, String account, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.password = password;
        this.email = email;
    }

    public User(String firstName, String lastName, String account, String password, String email, Set<Recipe> recipes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.password = password;
        this.email = email;
        this.recipes = recipes;
    }

    public User(String firstName, String lastName, String account, String password, String email, Set<Recipe> recipes, Set<Favorite> favorites) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.password = password;
        this.email = email;
        this.recipes = recipes;
        this.favorites = favorites;
    }

    public User(String firstName, String lastName, String account, String password, String email, Set<Recipe> recipes, Set<Favorite> favorites, Set<Meal> meals) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.password = password;
        this.email = email;
        this.recipes = recipes;
        this.favorites = favorites;
        this.meals = meals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
