package com.masai.service;

import java.util.Map;

import com.masai.entities.Bus;

import com.masai.exceptions.BusException;




public class BusServiceEmpl implements BusService {

	public BusServiceEmpl() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String addBus(Bus pro, Map<Integer, Bus> products) {
		// TODO Auto-generated method stub
		products.put(pro.getId(), pro);
		return "Product added successfully";
	}

	@Override
	public void viewAllBuses(Map<Integer, Bus> products) throws BusException {
		// TODO Auto-generated method stub
		if (products != null && products.size() > 0) {
			for (Map.Entry<Integer, Bus> me : products.entrySet()) {
				System.out.println(me.getValue());
			}

		} else {
			throw new BusException("Product List is empty");
		}
	}

	@Override
	public void deleteBus(int id, Map<Integer, Bus> products) throws BusException {
		if (products != null && products.size() > 0) {

			if (products.containsKey(id)) {
				products.remove(id);
				System.out.println("product deleted successfully");

			} else {
				throw new BusException("Bus not found");
			}

		} else {
			throw new BusException("Bus list is empty");
		}
		
	}

	@Override
	public String updateBus(int id,String name,int totalSeat,String busType, Map<Integer, Bus> buslist) throws BusException {

		if (buslist.isEmpty()) {
	        throw new BusException("Bus List is empty. Please add buses first!");
	    }
	    if (!buslist.containsKey(id)) {
	        throw new BusException("Bus with ID " + id + " not found!");
	    }
	    Bus bus = buslist.get(id);
	    Bus update=new Bus(id,name,totalSeat,bus.getSource(),bus.getDestination(),busType,bus.getDepartureTime(),bus.getArrivalTime(),bus.getBusNumber());
			if (buslist.containsKey(id)) {
				buslist.put(id, update);
				return "Bus has successfully updated";
			} else {
				throw new BusException("Bus not found");
			}

	}
		

	
		
	

}
