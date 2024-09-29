package com.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PetStoreApi {

    public PetStoreApi() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    public Response cadastrarPedido(String requestBody) {
        return RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/store/order");
    }

    public Response pesquisarPetsPorStatus(String status) {
        return RestAssured.given()
                .queryParam("status", status)
                .get("/pet/findByStatus");
    }

    public Response obterPetPorId(int petId) {
        return RestAssured.get("/pet/" + petId);
    }

    public Response atualizarPet(String requestBody) {
        return RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .put("/pet");
    }
}