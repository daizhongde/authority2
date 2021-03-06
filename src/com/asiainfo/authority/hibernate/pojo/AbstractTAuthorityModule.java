package com.asiainfo.authority.hibernate.pojo;

import java.util.Date;

/**
 * AbstractTAuthorityModule entity provides the base persistence definition of
 * the TAuthorityModule entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTAuthorityModule implements
		java.io.Serializable {

	// Fields

	private Integer NMid;
	private String CMname;
	private Short NMlevel;
	private String CMleaf;
	private Short NMorder;
	private Integer NMparent;
//	private TAuthorityModule NMparent;
	
	private String CMtarget;
	private String CMiconcls;
	private String CMexpanded;
	private String CMchecked;
	private String CMpath;
	private String CMnote;
	private Date CMctime;
	private String CMcip;
	private String CMcreator;
	private Date CMmtime;
	private String CMmip;
	private String CMmodifier;
	private String CMons;
	private Date CMont;
	
	// Constructors

	/** default constructor */
	public AbstractTAuthorityModule() {
	}

	/** minimal constructor */
	public AbstractTAuthorityModule(Integer NMid, String CMname, Short NMlevel,
			String CMleaf, Short NMorder, Date CMctime) {
		this.NMid = NMid;
		this.CMname = CMname;
		this.NMlevel = NMlevel;
		this.CMleaf = CMleaf;
		this.NMorder = NMorder;
		this.CMctime = CMctime;
	}

	/** full constructor */
	public AbstractTAuthorityModule(Integer NMid, String CMname, Short NMlevel,
			String CMleaf, Short NMorder, Integer NMparent, String CMtarget,
			String CMiconcls, String CMexpanded, String CMchecked,
			String CMpath, String CMnote, Date CMctime, String CMcip,
			String CMcreator, Date CMmtime, String CMmip, String CMmodifier,
			String CMons, Date CMont) {
		this.NMid = NMid;
		this.CMname = CMname;
		this.NMlevel = NMlevel;
		this.CMleaf = CMleaf;
		this.NMorder = NMorder;
		this.NMparent = NMparent;
		this.CMtarget = CMtarget;
		this.CMiconcls = CMiconcls;
		this.CMexpanded = CMexpanded;
		this.CMchecked = CMchecked;
		this.CMpath = CMpath;
		this.CMnote = CMnote;
		this.CMctime = CMctime;
		this.CMcip = CMcip;
		this.CMcreator = CMcreator;
		this.CMmtime = CMmtime;
		this.CMmip = CMmip;
		this.CMmodifier = CMmodifier;
		this.CMons = CMons;
		this.CMont = CMont;
	}

	// Property accessors

	public Integer getNMid() {
		return this.NMid;
	}

	public void setNMid(Integer NMid) {
		this.NMid = NMid;
	}

	public String getCMname() {
		return this.CMname;
	}

	public void setCMname(String CMname) {
		this.CMname = CMname;
	}

	public Short getNMlevel() {
		return this.NMlevel;
	}

	public void setNMlevel(Short NMlevel) {
		this.NMlevel = NMlevel;
	}

	public String getCMleaf() {
		return this.CMleaf;
	}

	public void setCMleaf(String CMleaf) {
		this.CMleaf = CMleaf;
	}

	public Short getNMorder() {
		return this.NMorder;
	}

	public void setNMorder(Short NMorder) {
		this.NMorder = NMorder;
	}

	public Integer getNMparent() {
		return this.NMparent;
	}

	public void setNMparent(Integer NMparent) {
		this.NMparent = NMparent;
	}

	public String getCMtarget() {
		return this.CMtarget;
	}

	public void setCMtarget(String CMtarget) {
		this.CMtarget = CMtarget;
	}

	public String getCMiconcls() {
		return this.CMiconcls;
	}

	public void setCMiconcls(String CMiconcls) {
		this.CMiconcls = CMiconcls;
	}

	public String getCMexpanded() {
		return this.CMexpanded;
	}

	public void setCMexpanded(String CMexpanded) {
		this.CMexpanded = CMexpanded;
	}

	public String getCMchecked() {
		return this.CMchecked;
	}

	public void setCMchecked(String CMchecked) {
		this.CMchecked = CMchecked;
	}

	public String getCMpath() {
		return this.CMpath;
	}

	public void setCMpath(String CMpath) {
		this.CMpath = CMpath;
	}

	public String getCMnote() {
		return this.CMnote;
	}

	public void setCMnote(String CMnote) {
		this.CMnote = CMnote;
	}

	public Date getCMctime() {
		return this.CMctime;
	}

	public void setCMctime(Date CMctime) {
		this.CMctime = CMctime;
	}

	public String getCMcip() {
		return this.CMcip;
	}

	public void setCMcip(String CMcip) {
		this.CMcip = CMcip;
	}

	public String getCMcreator() {
		return this.CMcreator;
	}

	public void setCMcreator(String CMcreator) {
		this.CMcreator = CMcreator;
	}

	public Date getCMmtime() {
		return this.CMmtime;
	}

	public void setCMmtime(Date CMmtime) {
		this.CMmtime = CMmtime;
	}

	public String getCMmip() {
		return this.CMmip;
	}

	public void setCMmip(String CMmip) {
		this.CMmip = CMmip;
	}

	public String getCMmodifier() {
		return this.CMmodifier;
	}

	public void setCMmodifier(String CMmodifier) {
		this.CMmodifier = CMmodifier;
	}

	public String getCMons() {
		return CMons;
	}

	public void setCMons(String cMons) {
		CMons = cMons;
	}

	public Date getCMont() {
		return CMont;
	}

	public void setCMont(Date cMont) {
		CMont = cMont;
	}

}