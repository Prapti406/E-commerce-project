package com.product.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name="category_tab")
//@NamedQuery(name="Product.findid", query="SELECT Product.id FROM Category INNER JOIN  Product ON Category.categoryid=Product.cat_fk")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="category_id")	
	private long categoryid;
	@Column(name="category_name")
	private String productType;
	@OneToMany(targetEntity =Product.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="cat_fk",referencedColumnName = "category_id")
	private List<Product> poductlist;
	
	
}

