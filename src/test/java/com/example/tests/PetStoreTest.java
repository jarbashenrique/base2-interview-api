package com.example.tests;

import com.example.api.PetStoreApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class PetStoreTest {

    PetStoreApi petStoreApi = new PetStoreApi();

    @Test
    public void deveCadastrarNovoPedidoComSucesso() {
        String requestBody = "{ \"id\": 1, \"petId\": 1, \"quantity\": 1, \"shipDate\": \"2024-09-28T23:22:53.529Z\", \"status\": \"placed\", \"complete\": true }";

        Response response = petStoreApi.cadastrarPedido(requestBody);
        response.then()
                .statusCode(200)
                .body("status", equalTo("placed"));
    }

    // Cenário Negativo: porem api nao espera o comportamento
    @Test
    public void naoDeveCadastrarPedidoSemDados() {
        String requestBody = "{}";

        Response response = petStoreApi.cadastrarPedido(requestBody);
        response.then()
                .statusCode(400); // ta vindo 200
    }

    @Test
    public void devePesquisarPetsComStatusPending() {
        Response response = petStoreApi.pesquisarPetsPorStatus("pending");
        response.then()
                .statusCode(200)
                .body("status", hasItem("pending"));
    }

    // Cenário Negativo: porem api nao espera o comportamento
    @Test
    public void naoDeveRetornarPetsComStatusInvalido() {
        Response response = petStoreApi.pesquisarPetsPorStatus("invalid_status");
        response.then()
                .statusCode(400); // ta vindo 200
    }

    @Test
    public void deveRetornarPetPorId() {
        int petId = 1;

        Response response = petStoreApi.obterPetPorId(petId);
        response.then()
                .statusCode(200)
                .body("id", equalTo(petId));
    }

    @Test
    public void deveRetornarErroAoPesquisarPetInexistente() {
        int petId = 157839210;

        Response response = petStoreApi.obterPetPorId(petId);
        response.then()
                .statusCode(404);
    }

    @Test
    public void deveAtualizarPetExistente() {
        String requestBody = "{ \"id\": 1, \"category\": { \"id\": 1, \"name\": \"Dogs\" }, \"name\": \"doggie\", \"photoUrls\": [\"string\"], \"tags\": [{ \"id\": 1, \"name\": \"tag1\" }], \"status\": \"available\" }";

        Response response = petStoreApi.atualizarPet(requestBody);
        response.then()
                .statusCode(200)
                .body("name", equalTo("doggie"))
                .body("status", equalTo("available"));
    }

    // Cenário Negativo: porem api nao espera o comportamento
    @Test
    public void naoDeveAtualizarPetInexistente() {
        String requestBody = "{ \"id\": 918102380391, \"category\": { \"id\": 1, \"name\": \"Dogs\" }, \"name\": \"doggie\", \"photoUrls\": [\"string\"], \"tags\": [{ \"id\": 1, \"name\": \"tag1\" }], \"status\": \"available\" }";

        Response response = petStoreApi.atualizarPet(requestBody);
        response.then()
                .statusCode(404); // ta vindo 200
    }
}