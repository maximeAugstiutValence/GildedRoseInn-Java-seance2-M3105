package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static List<Item> items = null;
	
	private static final int QUALITY_MAX = 50;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));
		
		
		updateShop();
	}
	
	
	public static void updateSellIn(Item item){
		
		
			if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
			{
				item.setSellIn(item.getSellIn() - 1);
			}
		
	}
	public static void updateQuality(Item item){
		
		if ((!"Aged Brie".equals(item.getName()))
				&& !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
		{
			if (item.getQuality() > 0)
			{
				if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
				{
					item.setQuality(item.getQuality() - 1);
				}
			}
		}
		
		else
		{
			if (item.getQuality() < QUALITY_MAX)
			{
				item.setQuality(item.getQuality() + 1);
	
				if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
				{
					if (item.getSellIn() < 11)
					{
						if (item.getQuality() < QUALITY_MAX)
						{
							item.setQuality(item.getQuality() + 1);
						}
					}
	
					if (item.getSellIn() < 6)
					{
						if (item.getQuality() < QUALITY_MAX)
						{
							item.setQuality(item.getQuality() + 1);
						}
					}
				}
			}
		}
		
		
		if (items.get(i).getSellIn() < 0)
		{
			if (!"Aged Brie".equals(items.get(i).getName()))
			{
				if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
				{
					if (items.get(i).getQuality() > 0)
					{
						if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
						{
							items.get(i).setQuality(items.get(i).getQuality() - 1);
						}
					}
				}
				else
				{
					items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
				}
			}
			else
			{
				if (items.get(i).getQuality() < QUALITY_MAX)
				{
					items.get(i).setQuality(items.get(i).getQuality() + 1);
				}
			}
		}
	
	
	
	
	}
		
		
	
	// update the shop (each item)
	public static void updateShop()
	{
		for (int i = 0; i < items.size(); i++)
		{
			
			
			updateSellIn(items.get(i));
			
			updateQuality(items.get(i));
			
		
		}

	}
}