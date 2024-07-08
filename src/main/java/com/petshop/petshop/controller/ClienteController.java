package com.petshop.petshop.controller;


import com.petshop.petshop.model.Cliente;
import com.petshop.petshop.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para listar todos os clientes
    @GetMapping("/")
    public String getAllClientes(Model model) {
        List<Cliente> clientes = clienteService.getAll();
        model.addAttribute("clientes", clientes);
        return "clientes-list"; // Nome do arquivo HTML Thymeleaf (clientes-list.html)
    }

    // Endpoint para exibir detalhes de um cliente específico
    @GetMapping("/{id}")
    public String getClienteById(@PathVariable("id") Long id, Model model) {
        Optional<Cliente> cliente = clienteService.getById(id);
        cliente.ifPresent(c -> model.addAttribute("cliente", c));
        return "cliente-details"; // Nome do arquivo HTML Thymeleaf (cliente-details.html)
    }

    // Endpoint para exibir o formulário de cadastro de cliente
    @GetMapping("/new")
    public String showClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente-form"; // Nome do arquivo HTML Thymeleaf (cliente-form.html)
    }

    // Endpoint para processar o formulário de cadastro de cliente
    @PostMapping("/save")
    public String saveCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.create(cliente);
        return "redirect:/clientes/"; // Redireciona para a lista de clientes após salvar
    }

    // Endpoint para exibir o formulário de edição de cliente
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Cliente> cliente = clienteService.getById(id);
        cliente.ifPresent(c -> model.addAttribute("cliente", c));
        return "cliente-form"; // Nome do arquivo HTML Thymeleaf (cliente-form.html) para edição
    }

    // Endpoint para processar o formulário de edição de cliente
    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable("id") Long id, @ModelAttribute("cliente") Cliente clienteDetails) {
        Optional<Cliente> updatedCliente = clienteService.update(id, clienteDetails);
        // Lógica para tratamento de erro se cliente não for encontrado
        return "redirect:/clientes/"; // Redireciona para a lista de clientes após atualizar
    }

    // Endpoint para deletar um cliente
    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable("id") Long id) {
        clienteService.delete(id);
        return "redirect:/clientes/"; // Redireciona para a lista de clientes após deletar
    }
}