package praktikum.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MoveIngredientParameterizedTest {
    private Burger burger;
    private int index;
    private int newIndex;

    public MoveIngredientParameterizedTest(int index, int newIndex) {
        this.index = index;
        this.newIndex = newIndex;
    }


    @Before
    public void initBurger() {
        burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
    }

    @Parameterized.Parameters(name = "Тест №{index}: индекс в списке был изменен с {0} на {1}")
    public static Object[] getIngredientsIndex() {
        return new Object[][]{
            {0, 2},
            {1, 1},
            {2, 0}
        };
    }

    // Тестирование метода moveIngredient в классе Burger
    // Индекс ингредиента изменен
    @Test
    public void ingredientIndexChanged() {
        List<Ingredient> originalIngredients = new ArrayList<>(burger.ingredients);
        Ingredient ingredientToMove = originalIngredients.get(index);

        // Размер списка до перемещения ингредиентов
        int originalSize = originalIngredients.size();

        // Вызываем метод moveIngredient, изменяем индекс элемента
        burger.moveIngredient(index, newIndex);

        // Проверяем, что индекс элемента изменен
        assertEquals(ingredientToMove, burger.ingredients.get(newIndex));
    }

    // Тестирование метода moveIngredient в классе Burger
    // Размер списка остался без изменений
    @Test
    public void theListSizeRemainsUnchanged() {
        List<Ingredient> originalIngredients = new ArrayList<>(burger.ingredients);
        Ingredient ingredientToMove = originalIngredients.get(index);

        // Размер списка до перемещения ингредиентов
        int originalSize = originalIngredients.size();

        // Вызываем метод moveIngredient, изменяем индекс элемента
        burger.moveIngredient(index, newIndex);

        // Проверяем, что размер списка остался без изменений
        assertEquals(originalSize, burger.ingredients.size());
    }

}