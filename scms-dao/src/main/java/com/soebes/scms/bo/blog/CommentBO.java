package com.soebes.scms.bo.blog;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.soebes.scms.bo.BaseBO;
import com.soebes.scms.bo.TableNames;


@Entity
@Table(name = TableNames.COMMENT)
public class CommentBO extends BaseBO {

    private String title;
    private String post;

//    @ManyToOne
//    private BlogPostBO blogPost;
    
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
        CommentBO other = (CommentBO) obj;
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
//	public BlogPostBO getBlogPost() {
//		return blogPost;
//	}
//	public void setBlogPost(BlogPostBO blogPost) {
//		this.blogPost = blogPost;
//	}
//
//    
}
