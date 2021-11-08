package ca.gbc.comp3095.gbccomp3095assignment1.bootstrap;

import ca.gbc.comp3095.gbccomp3095assignment1.domain.Favorite;
import ca.gbc.comp3095.gbccomp3095assignment1.domain.Meal;
import ca.gbc.comp3095.gbccomp3095assignment1.domain.Recipe;
import ca.gbc.comp3095.gbccomp3095assignment1.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ca.gbc.comp3095.gbccomp3095assignment1.repositories.FavoriteRepository;
import ca.gbc.comp3095.gbccomp3095assignment1.repositories.MealRepository;
import ca.gbc.comp3095.gbccomp3095assignment1.repositories.RecipeRepository;
import ca.gbc.comp3095.gbccomp3095assignment1.repositories.UserRepository;

import java.util.Date;

@Component
public class bootStrapData implements CommandLineRunner {

    private  UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final MealRepository mealRepository;
    private final FavoriteRepository favoriteRepository;


    public bootStrapData(UserRepository userRepository, RecipeRepository recipeRepository, MealRepository mealRepository, FavoriteRepository favoriteRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
        this.mealRepository = mealRepository;
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Create  Users
        User user1 = new User("Tan Loi", "Ngo","JackNgo","admin123","tanloi.ngo@georgebrown.ca");
        User user2 = new User("Minh Thanh", "Duong","MinhThanh","admin123","minhthanh.duong@georgebrown.ca");
        User user3 = new User("Thi Kim Thao", "Tran","MinTran","admin123","thikimthao.tran@georgebrown.ca");
        User user4 = new User("Hoang Thinh", "Tran","ThinhTran","admin123","hoangthinh.tran@georgebrown.ca");

        //Create a recipe
        Recipe recipe1 = new Recipe("Vietnamese Pho Noodle Soup","Beef bone, beef flank, sugar, salt, ginger, onion, green onion, fish sauce, cinnamon, star anise, coriander, dried noodle",
                "Quick boil – Remove impurities from beef with a 5 minute boil, it’s the path to a beautiful clear soup; " +
                        "","6 hours");
        Recipe recipe2 = new Recipe("Crab soup", "crab, tomatoes, chicken bone, salt, sugar","boil chiken bone,....","2 hours");
        Recipe recipe3 = new Recipe("Cinnamon bun", "cinnamon powder, all-purpose flour, yeast,...","mixing sugar, salt, butter", "4 hours");
        Recipe recipe4 = new Recipe("deep-fried fish", "fish, oil, fish sauce, sugar","deep-fried fish", "20 minutes");

        //Create a favorite
        Favorite favorite1 = new Favorite(user1, recipe1);
        Favorite favorite2 = new Favorite(user2, recipe1);
        Favorite favorite3 = new Favorite(user3, recipe1);
        Favorite favorite4 = new Favorite(user4, recipe1);


        //Create Meals
        Meal meal1 = new Meal("Vietnamese Pho Noodle Soup",new Date(),"Pho for dinner");
        Meal meal2 = new Meal("Stir-fried Veggies",new Date()," for Lunch");
        Meal meal3 = new Meal("crab soup",new Date()," for Lunch");
        Meal meal4 = new Meal("sushi",new Date()," for Dinner");


        meal1.setUsers(user1);
        meal2.setUsers(user2);
        meal3.setUsers(user3);
        meal4.setUsers(user4);


        user1.getRecipes().add(recipe1);
        user1.getFavorites().add(favorite1);
        user1.getMeals().add(meal1);

        user2.getRecipes().add(recipe2);
        user2.getFavorites().add(favorite2);
        user2.getMeals().add(meal2);

        user3.getRecipes().add(recipe3);
        user3.getFavorites().add(favorite3);
        user3.getMeals().add(meal3);

        user4.getRecipes().add(recipe4);
        user4.getFavorites().add(favorite4);
        user4.getMeals().add(meal4);


        recipe1.setUsers(user1);
        recipe1.getFavorites().add(favorite1);

        recipe2.setUsers(user2);
        recipe2.getFavorites().add(favorite2);

        recipe3.setUsers(user3);
        recipe3.getFavorites().add(favorite3);

        recipe4.setUsers(user4);
        recipe4.getFavorites().add(favorite4);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        mealRepository.save(meal1);
        mealRepository.save(meal2);
        mealRepository.save(meal3);
        mealRepository.save(meal4);

        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);
        recipeRepository.save(recipe3);
        recipeRepository.save(recipe4);


        favoriteRepository.save(favorite1);
        favoriteRepository.save(favorite2);
        favoriteRepository.save(favorite3);
        favoriteRepository.save(favorite4);

        System.out.println("Started in Bootstrap...");
        System.out.println("Number of Users " + userRepository.count());
        System.out.println("Number of Recipes " + recipeRepository.count());
        System.out.println("Number of Meals " + mealRepository.count());
        System.out.println("Number of Favorites " + favoriteRepository.count());










    }
}
