package com.sharad.quizbowlclassifier.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryList {
	HashMap<String, Category> categories;
	List<Supercategory> supers = new ArrayList<Supercategory>();

	public CategoryList() {
		Supercategory literature = new Supercategory("Literature");
		Supercategory history = new Supercategory("History");
		Supercategory science = new Supercategory("Science");
		Supercategory religion = new Supercategory("Religion");
		Supercategory mythology = new Supercategory("Mythology");
		Supercategory philosophy = new Supercategory("Philosophy");
		Supercategory finearts = new Supercategory("Fine Arts");
		Supercategory geography = new Supercategory("Geography");
		Supercategory ss = new Supercategory("Social Science");
		Supercategory trash = new Supercategory("Trash");
		supers.add(literature);
		supers.add(history);
		supers.add(science);
		supers.add(religion);
		supers.add(philosophy);
		supers.add(mythology);
		supers.add(finearts);
		supers.add(geography);
		supers.add(ss);
		supers.add(trash);
		categories = new HashMap<String, Category>();
		categories.put("am_lit",
				new Category("American Literature", literature));
		categories
				.put("br_lit", new Category("British Literature", literature));
		categories.put("eu_lit",
				new Category("European Literature", literature));
		categories.put("wo_lit", new Category("World Literature", literature));
		categories.put("am_his", new Category("American History", history));
		categories.put("br_his", new Category("British History", history));
		categories.put("eu_his", new Category("European History", history));
		categories.put("wo_his", new Category("World History", history));
		categories.put("ph_sci", new Category("Physics", science));
		categories.put("bi_sci", new Category("Biology", science));
		categories.put("ch_sci", new Category("Chemistry", science));
		categories.put("as_sci", new Category("Astronomy", science));
		categories.put("ma_sci", new Category("Mathematics", science));
		categories.put("ea_sci", new Category("Earth Science", science));
		categories.put("co_sci", new Category("Computer Science", science));

		categories.put("ch_rel", new Category("Christianity", religion));
		categories.put("ju_rel", new Category("Judaism", religion));
		categories.put("is_rel", new Category("Islam", religion));
		categories.put("ot_rel", new Category("Other", religion));

		categories.put("an_phi", new Category("Ancient", philosophy));
		categories.put("am_phi", new Category("American", philosophy));
		categories.put("eu_phi", new Category("European", philosophy));
		categories.put("ot_phi", new Category("Other", philosophy));

		categories.put("gr_myt", new Category("Greco-Roman", mythology));
		categories.put("no_myt", new Category("Norse", mythology));
		categories.put("ce_myt", new Category("Celtic", mythology));
		categories.put("in_myt", new Category("Indian", mythology));
		categories.put("as_myt", new Category("Asian", mythology));
		categories.put("ot_myt", new Category("Other", mythology));

		categories.put("pa_fa", new Category("Painting", finearts));
		categories.put("mu_fa", new Category("Classical Music", finearts));
		categories.put("sc_fa", new Category("Sculpture", finearts));
		categories.put("op_fa", new Category("Opera", finearts));
		categories.put("ar_fa", new Category("Architecture", finearts));
		categories.put("fi_fa", new Category("Film", finearts));
		categories.put("ot_fa", new Category("Other", finearts));

		categories.put("af_geo", new Category("African", geography));
		categories.put("as_geo", new Category("Asian", geography));
		categories.put("na_geo", new Category("North American", geography));
		categories.put("sa_geo", new Category("South American", geography));
		categories.put("eu_geo", new Category("European", geography));
		categories.put("ot_geo", new Category("Other", geography));

		categories.put("ec_ss", new Category("Economics", ss));
		categories.put("an_ss", new Category("Anthropology", ss));
		categories.put("ps_ss", new Category("Psychology", ss));
		categories.put("so_ss", new Category("Sociology", ss));
		categories.put("li_ss", new Category("Linguistics", ss));
		categories.put("go_ss", new Category("Government", ss));
		categories.put("ot_ss", new Category("Other", ss));

		categories.put("sp_tra", new Category("Sports", trash));
		categories.put("mu_tra", new Category("Music", trash));
		categories.put("mo_tra", new Category("Movies", trash));
		categories.put("vg_tra", new Category("Video Games", trash));
		categories.put("tv_tra", new Category("TV", trash));
		categories.put("ot_tra", new Category("Other", trash));

	}

	public List<Supercategory> getSupers() {
		return supers;
	}

	public HashMap<String, Category> getCategories() {
		return categories;
	}
}
