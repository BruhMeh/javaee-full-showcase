package br.com.javaee.fullshowcase.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
public class Book {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
    private String title;
    @Lob
    @Length(min=10)
    @NotBlank
    private String description;
    @DecimalMin("20")
    private BigDecimal price;
    private Integer pages;
    
    @Temporal(TemporalType.DATE)
    private Calendar datePublished;
    
    @ManyToMany
    @Size(min=1)
    @NotNull
    private List<Author> authors = new ArrayList<>();
    
    
    public Integer getId() {
    	return id;
    }
    public void setId(Integer id) {
    	this.id = id;
    }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price + ", pages="
				+ pages + ", authors=" + authors + "]";
	}
	public Calendar getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(Calendar datePublished) {
		this.datePublished = datePublished;
	}

}
