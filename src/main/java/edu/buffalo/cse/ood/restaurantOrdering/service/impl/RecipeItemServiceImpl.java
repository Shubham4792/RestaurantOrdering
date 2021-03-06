package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.Item;
import edu.buffalo.cse.ood.restaurantOrdering.model.RecipeItem;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.service.RecipeItemService;

@Service
public class RecipeItemServiceImpl extends ServiceImpl implements RecipeItemService {

	@Override
	public List<RecipeItem> getAllRecipeItems() {
		return getRecipeItemRepository().findAll();
	}

	@Override
	public RecipeItem getRecipeItemById(Long id) {
		return getRecipeItemRepository().findOne(id);
	}

	@Override
	public RecipeItem addRecipeItem(RecipeItem recipeItem) {
		return getRecipeItemRepository().save(recipeItem);
	}

	@Override
	public void updateRecipeItem(RecipeItem recipeItem) {
		getRecipeItemRepository().save(recipeItem);
	}

	@Override
	public void deleteRecipeItem(Long id) {
		getRecipeItemRepository().delete(id);
	}

	@Override
	public List<RecipeItem> getRecipeItemsNew(Long id) {
		Restaurant restaurant = getRestaurantRepository().findOne(id);
		List<RecipeItem> allItems = getRecipeItemRepository().findAll();
		List<Long> indexList = new ArrayList<>();
		long index = 0;
		for (Item item : allItems) {
			for (Item resItem : restaurant.getAvailableItems()) {
				if (resItem.getId() == item.getId()) {
					indexList.add(index);
				}
			}
			index++;
		}
		Collections.reverse(indexList);
		for (Long ind : indexList) {
			allItems.remove(ind.intValue());
		}
		return allItems;
	}

}
