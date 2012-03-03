package com.soebes.scms.bo.blog;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.soebes.scms.bo.BaseBO;
import com.soebes.scms.bo.TableNames;

@Entity
@Table(name = TableNames.BLOG_POST)
public class BlogPostBO extends BaseBO {

    private String title;
    private String post;
    
//    @OneToMany(mappedBy = "comments")
//    @JoinColumn(name = "comment_id")
//    @JoinTable(name= "blogsposts_comments" )
//    private ArrayList<CommentBO> comments;
    private String comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((post == null) ? 0 : post.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        BlogPostBO other = (BlogPostBO) obj;
        if (post == null) {
            if (other.post != null)
                return false;
        } else if (!post.equals(other.post))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
