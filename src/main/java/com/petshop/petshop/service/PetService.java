
package com.petshop.petshop.service;

import com.petshop.petshop.model.Pet;
import com.petshop.petshop.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    // Método para buscar todos os pets
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    // Método para buscar um pet por ID
    public Optional<Pet> getPetById(Long id) {
        return petRepository.findById(id);
    }

    // Método para salvar um novo pet
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    // Método para atualizar um pet existente
    public Optional<Pet> updatePet(Long id, Pet petDetails) {
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isEmpty()) {
            return Optional.empty();
        }
        Pet pet = optionalPet.get();
        pet.setNome(petDetails.getNome());
        pet.setEspecie(petDetails.getEspecie());
        pet.setRaca(petDetails.getRaca());
        pet.setIdade(petDetails.getIdade());
        pet.setCliente(petDetails.getCliente());

        return Optional.of(petRepository.save(pet));
    }

    // Método para deletar um pet
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
