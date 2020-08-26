package com.epam.order.item.intergration;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.order.item.OrderItemApplication;
import com.epam.order.item.entity.OrderItem;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderItemApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerIntegrationTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();


    @Test
    public void testAddOrder() throws JSONException {
        OrderItem order = new OrderItem();
        order.setId(1L);
        
        HttpEntity<OrderItem> entity = new HttpEntity<OrderItem>(order, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/order"),
                HttpMethod.POST, entity, String.class);

        String expected = "{\"id\":\"1\",\"name\":\"aaa\",\"description\":\"desc\"}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testAllOrders() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/order/1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{\"id\":\"1\",\"name\":\"bbb\",\"description\":\"desc\"}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
