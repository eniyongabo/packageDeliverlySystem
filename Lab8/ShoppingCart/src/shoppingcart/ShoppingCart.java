package shoppingcart;
import java.util.ArrayList;


import java.util.Iterator;

import products.Product;

public class ShoppingCart {
	ArrayList<CartLine> cartLines = new ArrayList<CartLine>();

	private boolean isProductInCartLine(Product product, CartLine cartLine) {
		return cartLine.getProduct().getProductnumber().equals(product.getProductnumber());
	}

	private boolean isNewProduct(Product product) {
		for (CartLine cartLine : cartLines) {
			if (isProductInCartLine(product, cartLine)) {
				return false;
			}
		}
		return true;
	}

	private void addNewProduct(Product product) {
		CartLine cartLine = new CartLine();
		cartLine.setProduct(product);
		cartLine.setQuantity(1);
		cartLines.add(cartLine);
	}

	private void addExistingProduct(Product product) {
		for (CartLine cartLine : cartLines) {
			if (isProductInCartLine(product, cartLine)) {
				cartLine.setQuantity(cartLine.getQuantity()+1);
			}
		}
	}

	public void addToCart(Product product) {
		if (!isNewProduct(product)) {
			addExistingProduct(product);
		}
		else {
			addNewProduct(product);
		}
	}

	public void removeFromCart(Product product){
		Iterator<CartLine> iter = cartLines.iterator();
		while (iter.hasNext()){
			CartLine cline = iter.next();
			if (isProductInCartLine(product, cline)){
				if (cline.getQuantity()>1){
					cline.setQuantity(cline.getQuantity()-1);
				}
				else{
					iter.remove();
				}
			}
		}
	}

	public void printCartDetails() {
		System.out.println("Content of the shoppingcart:");
		for (CartLine cartLine : cartLines) {
			System.out.println(cartLine.getQuantity() + " "
					+ cartLine.getProduct().getProductnumber() + " "
					+ cartLine.getProduct().getDescription() + " "
					+ cartLine.getProduct().getPrice());
		}
		System.out.println("Total price ="+computeTotalPrice());
	}

	public double computeTotalPrice(){
		double totalPrice = 0.0;
		for (CartLine cartLine : cartLines) {
			totalPrice = totalPrice + (cartLine.getProduct().getPrice() * cartLine.getQuantity());
		}
		return totalPrice;
	}
}
