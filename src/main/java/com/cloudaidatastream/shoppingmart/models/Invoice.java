package com.cloudaidatastream.shoppingmart.models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "INVOICE")
@EntityListeners(AuditingEntityListener.class)
public class Invoice extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long customer_id;
	private String order_id;
	private String detail;
	private boolean reverse_charge;
	private String transport_mode;
	private String vehical_number;
	private String date_of_supply;
	private String place_of_supply;
	private double total_base_price;
	private double total_tax1;
	private double total_tax2;
	private double total_tax3;
	private double total_amount;
	private double total_discount;
	private double total_net_amount;
	private double gross_amount;
	private Timestamp invoice_date;
	private byte[] image_file;
	private String type;
	private String status;
	private String other_info;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice", cascade = CascadeType.ALL)
	private Set<InvoiceDetail> invoceDetails = new HashSet<InvoiceDetail>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public double getTotal_base_price() {
		return total_base_price;
	}

	public void setTotal_base_price(double total_base_price) {
		this.total_base_price = total_base_price;
	}

	public double getTotal_tax1() {
		return total_tax1;
	}

	public void setTotal_tax1(double total_tax1) {
		this.total_tax1 = total_tax1;
	}

	public double getTotal_tax2() {
		return total_tax2;
	}

	public void setTotal_tax2(double total_tax2) {
		this.total_tax2 = total_tax2;
	}

	public double getTotal_tax3() {
		return total_tax3;
	}

	public void setTotal_tax3(double total_tax3) {
		this.total_tax3 = total_tax3;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public double getTotal_discount() {
		return total_discount;
	}

	public void setTotal_discount(double total_discount) {
		this.total_discount = total_discount;
	}

	public double getTotal_net_amount() {
		return total_net_amount;
	}

	public void setTotal_net_amount(double total_net_amount) {
		this.total_net_amount = total_net_amount;
	}

	public double getGross_amount() {
		return gross_amount;
	}

	public void setGross_amount(double gross_amount) {
		this.gross_amount = gross_amount;
	}

	public Timestamp getInvoice_date() {
		return invoice_date;
	}

	public void setInvoice_date(Timestamp invoice_date) {
		this.invoice_date = invoice_date;
	}

	public byte[] getImage_file() {
		return image_file;
	}

	public void setImage_file(byte[] image_file) {
		this.image_file = image_file;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOther_info() {
		return other_info;
	}

	public void setOther_info(String other_info) {
		this.other_info = other_info;
	}

	public Set<InvoiceDetail> getInvoceDetails() {
		return invoceDetails;
	}

	public void setInvoceDetails(Set<InvoiceDetail> invoceDetails) {
		this.invoceDetails = invoceDetails;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public boolean getReverse_charge() {
		return reverse_charge;
	}

	public void setReverse_charge( boolean reverse_charge) {
		this.reverse_charge = reverse_charge;
	}

	public String getTransport_mode() {
		return transport_mode;
	}

	public void setTransport_mode(String transport_mode) {
		this.transport_mode = transport_mode;
	}

	public String getVehical_number() {
		return vehical_number;
	}

	public void setVehical_number(String vehical_number) {
		this.vehical_number = vehical_number;
	}

	public String getDate_of_supply() {
		return date_of_supply;
	}

	public void setDate_of_supply(String date_of_supply) {
		this.date_of_supply = date_of_supply;
	}

	public String getPlace_of_supply() {
		return place_of_supply;
	}

	public void setPlace_of_supply(String place_of_supply) {
		this.place_of_supply = place_of_supply;
	}

}
