package ca.gbc.comp3095.gbccomp3095assignment1.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String ingredient;
    private String instruction;
    private String cookTime;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User users;

    @OneToMany(mappedBy = "recipes", cascade = CascadeType.ALL)
    private Set<Favorite> favorites = new HashSet<>();

    public Recipe(){
    }

    public Recipe(String title, String ingredient, String instruction, String cookTime) {
        this.title = title;
        this.ingredient = ingredient;
        this.instruction = instruction;
        this.cookTime = cookTime;
    }

    public Recipe(String title, String ingredient, String instruction, String cookTime, User users) {
        this.title = title;
        this.ingredient = ingredient;
        this.instruction = instruction;
        this.cookTime = cookTime;
        this.users = users;
    }

    public Recipe(String title, String ingredient, String instruction, String cookTime, User users, Set<Favorite> favorites) {
        this.title = title;
        this.ingredient = ingredient;
        this.instruction = instruction;
        this.cookTime = cookTime;
        this.users = users;
        this.favorites = favorites;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
