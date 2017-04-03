package com.iquest.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.iquest.constants.Cart;

@Entity
public class CartModel {

	@Id
	@Column(name = "cartId")
	private long cartId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserModel user;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cart_course", joinColumns = { @JoinColumn(name = "cartId") }, inverseJoinColumns = {
			@JoinColumn(name = "courseId") })
	private List<CourseModel> courses = new ArrayList<CourseModel>();

	private int grandTotal;

	private String approval;

	public CartModel() {
	}

	public CartModel(UserModel user) {
		this.user = user;
		this.approval = Cart.STATUS_UNFINISHED;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public List<CourseModel> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseModel> courses) {
		this.courses = courses;
	}

	public int getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void addCartItem(CourseModel course) {
		if (!courses.contains(course)) {
			courses.add(course);
		}
		updateGrandTotal();
	}

	public void removeCartItem(CourseModel course) {
		courses.remove(course);
		updateGrandTotal();
	}

	public void updateGrandTotal() {
		grandTotal = 0;
		for (CourseModel course : courses) {
			grandTotal = grandTotal + course.getPrice();
		}
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approval == null) ? 0 : approval.hashCode());
		result = prime * result + (int) (cartId ^ (cartId >>> 32));
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + grandTotal;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartModel other = (CartModel) obj;
		if (approval == null) {
			if (other.approval != null)
				return false;
		} else if (!approval.equals(other.approval))
			return false;
		if (cartId != other.cartId)
			return false;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (grandTotal != other.grandTotal)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
