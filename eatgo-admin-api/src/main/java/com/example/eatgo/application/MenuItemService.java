package com.example.eatgo.application;

import com.example.eatgo.domain.MenuItem;
import com.example.eatgo.domain.MenuItemRepository;
import com.example.eatgo.domain.Restaurant;
import com.example.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepositroy;

    public MenuItemService(MenuItemRepository menuItemRepository){
        this.menuItemRepositroy = menuItemRepository;
    }

    public List<MenuItem> getMenuItems(Long restaurantId){
        return menuItemRepositroy.findAllByRestaurantId(restaurantId);
    }

    public void bulkUpdate(Long restaurantId, List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems){
            update(restaurantId, menuItem);
        }
    }

    private void update(Long restaurantId, MenuItem menuItem) {
        // destroy 해야할 경우 삭제하고 return
        if(menuItem.isDestroy()){
            menuItemRepositroy.deleteById(menuItem.getId());
            return;
        }
        // 아닌경우 save
        menuItem.setRestaurantId(restaurantId);
        menuItemRepositroy.save(menuItem);
    }
}
