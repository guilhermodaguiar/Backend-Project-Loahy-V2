package nl.novi.loahy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name="remarks")
public class ContactRemark {

    @Id
    @Column
    private String contactName;
    @Column
    @Email
    private String contactEmail;
    @Column
    private Long contactPhone;
    @Column
    private String contactOrganisation;
    @Column(columnDefinition = "TEXT")
    private String remark;




    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Long getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Long contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactOrganisation() {
        return contactOrganisation;
    }

    public void setContactOrganisation(String contactOrganisation) {
        this.contactOrganisation = contactOrganisation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
