package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.HelloWorldController;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloTest() throws Exception {

		//「/helloworld」にgetメソッドでアクセスした結果を「resultActions」に格納する。
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/helloworld"));

		//resultActionsの中身を「andExpect」で覗いて、期待通りの結果になっているか確認する。
		resultActions.andExpect(status().isOk())
				//表示するview(html)の名前はhelloworldになっているか確認
				.andExpect(view().name("helloworld"))

				//モデルに「message」という名前の入れ物が作られているか確認
				.andExpect(model().attributeExists("message"))

				//「message」の中身が「Hello!!」になっているか確認
				.andExpect(model().attribute("message", "Hello!!"));
	}
}