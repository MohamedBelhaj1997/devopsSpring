package com.esprit.examen.services;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceImplTest {
	@Mock
	StockRepository stockRepository;
	@Autowired
	IStockService stockService;
	
	
	@Test
	public void testAddStock() {
			List<Stock> stocks = stockService.retrieveAllStocks();
			int expected=stocks.size();
			Stock s = new Stock("stock test",2,4);
			Stock savedStock= stockService.addStock(s);
			
		    assertEquals(expected+1, stockService.retrieveAllStocks().size());
			//assertNotNull(savedStock.getLibelleStock());
		    
		    Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s))
		    ;
		    //Stock stock1 = (Stock) stockService.retrieveAllStocks();
		    Assertions.assertNotNull(savedStock);
		    }
			
	} 
	/*
	@Test
	public void testAddStockOptimized() {

		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());
		
	} 

@Test
	public void testDeleteStock() {
	//Stock s = new Stock("stock test",30,60);
	//Stock savedStock= stockService.addStock(s);
	stockService.deleteStock((long) 28);
	//assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}
*/

