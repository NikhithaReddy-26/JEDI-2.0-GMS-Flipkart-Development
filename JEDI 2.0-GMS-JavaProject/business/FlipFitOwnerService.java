package com.flipkart.gms.business;

import java.util.List;

import com.flipkart.gms.beans.FlipFitOwner;
import com.flipkart.gms.beans.Gym;
import com.flipkart.gms.beans.Slot;
import com.flipkart.gms.dao.*;

/**
 * Represents services provided to FlipFit gym owners for managing gyms and slots.
 */
public class FlipFitOwnerService implements FlipFitOwnerServiceInterface {

	OwnerRepositoryInterface ownerRepository = new OwnerRepository();
	SlotRepositoryInterface slotRepository = new SlotRepository();
	GymRepositoryInterface gymRepository = new GymRepository();

	/**
	 * Authenticates a gym owner based on provided credentials.
	 *
	 * @param name     The name of the gym owner.
	 * @param password The password of the gym owner.
	 * @return The authenticated gym owner or null if authentication fails.
	 */
	public FlipFitOwner authenticate(String name, String password) {
		// Authentication logic
		List<FlipFitOwner> owners = ownerRepository.getOwners();

		for (FlipFitOwner owner : owners) {
			if (owner != null && owner.getName().equals(name) && owner.getPassword().equals(password)) {
				return owner;
			}
		}
		return null;
	}

	/**
	 * Retrieves all slots associated with a specific gym.
	 *
	 * @param gymId The ID of the gym for which slots are to be retrieved.
	 * @return A list of slots associated with the specified gym.
	 */
	public List<Slot> viewAllSlotsByGymId(int gymId) {
		// Slot retrieval logic
		return slotRepository.getAllSlotByGymId(gymId);
	}

	/**
	 * Registers a new gym with the provided details.
	 *
	 * @param ownerId      The ID of the owner registering the gym.
	 * @param gymName      The name of the new gym.
	 * @param gymLocation  The location of the new gym.
	 * @param seats        The number of seats in the new gym.
	 * @param amount       The registration amount for the new gym.
	 */
	public void registerGym(int ownerId, String gymName, String gymLocation, int seats, double amount) {
		// Gym registration logic
		gymRepository.registerGym(ownerId, gymName, gymLocation, seats, amount);
	}

	/**
	 * Retrieves all gyms associated with a specific owner.
	 *
	 * @param ownerId The ID of the owner for which gyms are to be retrieved.
	 * @return A list of gyms associated with the specified owner.
	 */
	public List<Gym> getAllGymByOwnerId(int ownerId) {
		// Gym retrieval logic
		return gymRepository.getGymByOwnerId(ownerId);
	}

	/**
	 * Checks if a specific gym is approved.
	 *
	 * @param gymId   The ID of the gym to be checked.
	 * @param ownerId The ID of the owner for which approval is to be checked.
	 * @return True if the gym is approved, false otherwise.
	 */
	public boolean checkGymApproval(int gymId, int ownerId) {
		// Gym approval check logic
		List<Gym> ownerGym = getAllGymByOwnerId(ownerId);
		for (Gym gym : ownerGym) {
			if (gym.getId() == gymId) {
				return gym.isApproved();
			}
		}
		return false;
	}

	/**
	 * Adds a new slot for a specific gym.
	 *
	 * @param gymId The ID of the gym for which a slot is to be added.
	 * @param time  The time of the new slot.
	 */
	public void addGym(int gymId, String time) {
		// Slot addition logic
		slotRepository.addSlot(gymId, time);
	}

	/**
	 * Retrieves a gym owner by their ID.
	 *
	 * @param ownerId The ID of the gym owner to be retrieved.
	 * @return The gym owner with the specified ID.
	 */
	public FlipFitOwner getOwnerById(int ownerId) {
		// Gym owner retrieval logic
		return ownerRepository.getGymOwnerById(ownerId);
	}

	/**
	 * Adds a new gym owner with the provided details.
	 *
	 * @param name      The name of the new gym owner.
	 * @param password1 The password of the new gym owner.
	 * @param address   The address of the new gym owner.
	 * @param email     The email of the new gym owner.
	 * @param phoneNum  The phone number of the new gym owner.
	 * @param gstNumber The GST number of the new gym owner.
	 */
	public void addOwner(String name, String password1, String address, String email, long phoneNum, String gstNumber) {
		// Gym owner addition logic
		ownerRepository.addOwner(name, password1, address, email, phoneNum, gstNumber);
	}
}
