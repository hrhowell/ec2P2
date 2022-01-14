package com.p2.recApp.shopinglist;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p2.recApp.recipes.Recipe;


@Repository
@Transactional()
public interface ShopingListRepository extends JpaRepository<ShopingList, Integer> {
	List<ShopingList> findByUsername(String username); 
	void deleteByUsername(String username);
		
}
