package orangeShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.orange.shop.Line;
import com.orange.shop.OrangeShopFinder;
import com.orange.shop.OrangeShopFinderImpl;
import com.orange.shop.ShopBean;

public class OrangeShopFinderTest {

	final List<ShopBean> shopBeantList = new ArrayList();
	List<ShopBean> shopUpperThenZeroList = new ArrayList();
	OrangeShopFinder orangeShopFinder = new OrangeShopFinderImpl();
	Map<String, Double> shopUpperThenZeroMap = new HashMap<>();

	@Before
	public void init() {
		ShopBean l1 = new ShopBean("-1.51815", "43.49507", "[Orange] 64 Anglet (Avenue Belle Marion)", "sunusng", "7");
		ShopBean l2 = new ShopBean("-2.51815", "30.49507", "[Orange] 47 Marmande (2-16 Rue Charles de Gaulle)", "weiwei",  "20");
		ShopBean l3 = new ShopBean("-3.51815", "60.49507", "[Orange nv] 22 Saint-Brieuc (16 Rue Saint-Guillaume)", "weiwei", "10");
				
		ShopBean l4 = new ShopBean("-3.51815", "60.49507", "[Orange nv] 22 Saint-Brieuc (16 Rue Saint-Guillaume)", "weiwei","30");
		ShopBean l5 = new ShopBean("-3.51815", "60.49507", "[Orange nv] 22 Saint-Brieuc (16 Rue Saint-Guillaume)", "weiwei", "20");

		shopBeantList.add(l1);
		shopBeantList.add(l2);
		shopBeantList.add(l3);
		shopBeantList.add(l4);
		shopBeantList.add(l5);

		
		shopUpperThenZeroMap.put("[Orange] 47 Marmande (2-16 Rue Charles de Gaulle)", 5516.926455618744);
		shopUpperThenZeroMap.put("[Orange] 64 Anglet (Avenue Belle Marion)", 4068.24231299198);
		shopUpperThenZeroMap.put("[Orange nv] 22 Saint-Brieuc (16 Rue Saint-Guillaume)", 2225.105287924221);

	}

	@Test
	public void testOrangeShopFinder() {

		OrangeShopFinder orangeShopFinder = new OrangeShopFinderImpl();
		String shop = orangeShopFinder.findOrangeShopWithMobileAvailable(5, 87, "sunusng");
		Assert.assertEquals(shop, "[Orange] 80 Péronne (CC Intermarché)");
	}


	@Test
	public void testSortShopWithDescendingDistance() {
		Map<String, Double> sortetdShopUpperThenZeroLinkedHashMap = new LinkedHashMap();
		sortetdShopUpperThenZeroLinkedHashMap= orangeShopFinder.sortShopWithDescendingDistance(shopUpperThenZeroMap);
		String closestShop=sortetdShopUpperThenZeroLinkedHashMap.keySet().iterator().next();
		Assert.assertEquals("[Orange nv] 22 Saint-Brieuc (16 Rue Saint-Guillaume)", closestShop);
	
	
	}

	@Test
	public void testGetClosestShopFromListShops() {
		
	    String closedShop = orangeShopFinder.getClosestShopFromListShops(1, 80, shopBeantList);
		Assert.assertEquals("[Orange nv] 22 Saint-Brieuc (16 Rue Saint-Guillaume)", closedShop);
	}

}
