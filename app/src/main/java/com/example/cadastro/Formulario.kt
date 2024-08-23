package com.example.cadastro

class Formulario(
    val nome: String,
    val telefone: String,
    val email: String,
    val ingressoListaEmail: Boolean,
    val sexo: String,
    val cidade: String,
    val uf: String
) {
    override fun toString(): String {
        return "Nome: $nome\nTelefone: $telefone\nEmail: $email\nCidade: $cidade\nUF: $uf\nIngressar na lista: $ingressoListaEmail\nSexo: $sexo"
    }
}
