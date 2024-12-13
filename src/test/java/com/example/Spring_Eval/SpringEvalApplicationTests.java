package com.example.Spring_Eval;

import com.example.Spring_Eval.controller.EntrepriseController;
import com.example.Spring_Eval.model.Convention;
import com.example.Spring_Eval.model.Entreprise;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.security.test.context.support.WithMockUser;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SpringEvalApplicationTests {

	@Autowired
	private MockMvc mvc;
    @Autowired
    private ObjectMapper jacksonObjectMapper;

	@Test
	@WithMockUser(username = "entrepriseA@example.com", roles={"ENTREPRISE"})
	void supprimerUneConventionEnTantQueEntreprise_reponse403forbidden() throws Exception{

		mvc.perform(delete("/convention/1"))
				.andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(username = "entrepriseA@example.com", roles={"ENTREPRISE"})
	void AjouterUneEntrepriseEnTantQueEntreprise_reponse403forbidden() throws Exception{

		Entreprise entreprise = new Entreprise();
		entreprise.setNom("entrepriseC");


		ObjectMapper objectMapper = new ObjectMapper();
		String entrepriseJson = objectMapper.writeValueAsString(entreprise);

		mvc.perform(post("/entreprise")
					.contentType(MediaType.APPLICATION_JSON)
					.content(entrepriseJson))
					.andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(username = "entrepriseA@example.com", roles={"ENTREPRISE"})
	void AjouterUneConventionEnTantQueEntreprise_reponse403forbidden() throws Exception{

		Convention convention = new Convention();
		convention.setNom("Convention 4");
		convention.setSubvention(10.5F);
		convention.setSalarie_maximum(1);


		ObjectMapper objectMapper = new ObjectMapper();
		String conventionjson = objectMapper.writeValueAsString(convention);

		mvc.perform(post("/convention")
						.contentType(MediaType.APPLICATION_JSON)
						.content(conventionjson))
				.andExpect(status().isForbidden());
	}







}
