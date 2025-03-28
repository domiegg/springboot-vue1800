<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>
				<!-- 商品搜索结果 -->
			  <list_result_search
				:list="result_goods"
				title="商城中心"
				source_table="goods"
			  ></list_result_search>

				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="商品资讯"
				source_table="article"
			  ></list_result_search>


									  <list_result_search
				v-if="$check_action('/ordinary_users/list', 'get')"
				:list="result_ordinary_users_user_name"
				title="普通用户用户姓名"
				source_table="ordinary_users"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/mall_center/list', 'get')"
				:list="result_mall_center_article_no"
				title="商城中心商品编号"
				source_table="mall_center"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/mall_center/list', 'get')"
				:list="result_mall_center_sales_type"
				title="商城中心销售类型"
				source_table="mall_center"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/help_center/list', 'get')"
				:list="result_help_center_help_topics"
				title="帮助中心帮助主题"
				source_table="help_center"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/member_center/list', 'get')"
				:list="result_member_center_user_name"
				title="会员中心用户姓名"
				source_table="member_center"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/member_center/list', 'get')"
				:list="result_member_center_member_id"
				title="会员中心会员号"
				source_table="member_center"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/member_center/list', 'get')"
				:list="result_member_center_customer_star_rating"
				title="会员中心客户星级"
				source_table="member_center"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/promotion_management/list', 'get')"
				:list="result_promotion_management_promotion_name"
				title="促销管理促销名称"
				source_table="promotion_management"
			  ></list_result_search>
											  <list_result_search
				v-if="$check_action('/promotion_management/list', 'get')"
				:list="result_promotion_management_promotional_products"
				title="促销管理促销商品"
				source_table="promotion_management"
			  ></list_result_search>
																								  <list_result_search
				v-if="$check_action('/operation_management/list', 'get')"
				:list="result_operation_management_operational_projects"
				title="运营管理运营项目"
				source_table="operation_management"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/operation_management/list', 'get')"
				:list="result_operation_management_operational_objectives"
				title="运营管理运营目标"
				source_table="operation_management"
			  ></list_result_search>
																	  <list_result_search
				v-if="$check_action('/operation_management/list', 'get')"
				:list="result_operation_management_person_in_charge"
				title="运营管理负责人"
				source_table="operation_management"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/financial_management/list', 'get')"
				:list="result_financial_management_month"
				title="财务管理月份"
				source_table="financial_management"
			  ></list_result_search>
																					</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_goods": [],
	  "result_article": [],
									"result_ordinary_users_user_name":[],
															"result_mall_center_article_no":[],
								"result_mall_center_sales_type":[],
												"result_help_center_help_topics":[],
															"result_member_center_user_name":[],
														"result_member_center_member_id":[],
								"result_member_center_customer_star_rating":[],
												"result_promotion_management_promotion_name":[],
											"result_promotion_management_promotional_products":[],
																								"result_operation_management_operational_projects":[],
								"result_operation_management_operational_objectives":[],
																	"result_operation_management_person_in_charge":[],
															"result_financial_management_month":[],
																			};
  },
  methods: {
	/**
	 * 获取${fmodel.filter.cart_name}
	 */
	get_goods() {
	  this.$get("~/api/goods/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_goods = json.result.list;
		}
	  });
	},
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},

							/**
	 * 获取user_name
	 */
	get_ordinary_users_user_name(){
		let url = "~/api/ordinary_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_ordinary_users_user_name = json.result.list;
			result_ordinary_users_user_name.map(o => o.title = o['user_name'])
	  			this.result_ordinary_users_user_name = result_ordinary_users_user_name
		 	}
		});
	},
													/**
	 * 获取article_no
	 */
	get_mall_center_article_no(){
		let url = "~/api/mall_center/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "article_no": this.query.word }, (json) => {
		  if (json.result) {
			var result_mall_center_article_no = json.result.list;
			result_mall_center_article_no.map(o => o.title = o['article_no'])
	  			this.result_mall_center_article_no = result_mall_center_article_no
		 	}
		});
	},
						/**
	 * 获取sales_type
	 */
	get_mall_center_sales_type(){
		let url = "~/api/mall_center/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "sales_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_mall_center_sales_type = json.result.list;
			result_mall_center_sales_type.map(o => o.title = o['sales_type'])
	  			this.result_mall_center_sales_type = result_mall_center_sales_type
		 	}
		});
	},
										/**
	 * 获取help_topics
	 */
	get_help_center_help_topics(){
		let url = "~/api/help_center/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "help_topics": this.query.word }, (json) => {
		  if (json.result) {
			var result_help_center_help_topics = json.result.list;
			result_help_center_help_topics.map(o => o.title = o['help_topics'])
	  			this.result_help_center_help_topics = result_help_center_help_topics
		 	}
		});
	},
													/**
	 * 获取user_name
	 */
	get_member_center_user_name(){
		let url = "~/api/member_center/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_member_center_user_name = json.result.list;
			result_member_center_user_name.map(o => o.title = o['user_name'])
	  			this.result_member_center_user_name = result_member_center_user_name
		 	}
		});
	},
												/**
	 * 获取member_id
	 */
	get_member_center_member_id(){
		let url = "~/api/member_center/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "member_id": this.query.word }, (json) => {
		  if (json.result) {
			var result_member_center_member_id = json.result.list;
			result_member_center_member_id.map(o => o.title = o['member_id'])
	  			this.result_member_center_member_id = result_member_center_member_id
		 	}
		});
	},
						/**
	 * 获取customer_star_rating
	 */
	get_member_center_customer_star_rating(){
		let url = "~/api/member_center/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "customer_star_rating": this.query.word }, (json) => {
		  if (json.result) {
			var result_member_center_customer_star_rating = json.result.list;
			result_member_center_customer_star_rating.map(o => o.title = o['customer_star_rating'])
	  			this.result_member_center_customer_star_rating = result_member_center_customer_star_rating
		 	}
		});
	},
										/**
	 * 获取promotion_name
	 */
	get_promotion_management_promotion_name(){
		let url = "~/api/promotion_management/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "promotion_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_promotion_management_promotion_name = json.result.list;
			result_promotion_management_promotion_name.map(o => o.title = o['promotion_name'])
	  			this.result_promotion_management_promotion_name = result_promotion_management_promotion_name
		 	}
		});
	},
									/**
	 * 获取promotional_products
	 */
	get_promotion_management_promotional_products(){
		let url = "~/api/promotion_management/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "promotional_products": this.query.word }, (json) => {
		  if (json.result) {
			var result_promotion_management_promotional_products = json.result.list;
			result_promotion_management_promotional_products.map(o => o.title = o['promotional_products'])
	  			this.result_promotion_management_promotional_products = result_promotion_management_promotional_products
		 	}
		});
	},
																						/**
	 * 获取operational_projects
	 */
	get_operation_management_operational_projects(){
		let url = "~/api/operation_management/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "operational_projects": this.query.word }, (json) => {
		  if (json.result) {
			var result_operation_management_operational_projects = json.result.list;
			result_operation_management_operational_projects.map(o => o.title = o['operational_projects'])
	  			this.result_operation_management_operational_projects = result_operation_management_operational_projects
		 	}
		});
	},
						/**
	 * 获取operational_objectives
	 */
	get_operation_management_operational_objectives(){
		let url = "~/api/operation_management/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "operational_objectives": this.query.word }, (json) => {
		  if (json.result) {
			var result_operation_management_operational_objectives = json.result.list;
			result_operation_management_operational_objectives.map(o => o.title = o['operational_objectives'])
	  			this.result_operation_management_operational_objectives = result_operation_management_operational_objectives
		 	}
		});
	},
															/**
	 * 获取person_in_charge
	 */
	get_operation_management_person_in_charge(){
		let url = "~/api/operation_management/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "person_in_charge": this.query.word }, (json) => {
		  if (json.result) {
			var result_operation_management_person_in_charge = json.result.list;
			result_operation_management_person_in_charge.map(o => o.title = o['person_in_charge'])
	  			this.result_operation_management_person_in_charge = result_operation_management_person_in_charge
		 	}
		});
	},
													/**
	 * 获取month
	 */
	get_financial_management_month(){
		let url = "~/api/financial_management/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "month": this.query.word }, (json) => {
		  if (json.result) {
			var result_financial_management_month = json.result.list;
			result_financial_management_month.map(o => o.title = o['month'])
	  			this.result_financial_management_month = result_financial_management_month
		 	}
		});
	},
																		
  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_goods();
	this.get_article();
								this.get_ordinary_users_user_name();
														this.get_mall_center_article_no();
							this.get_mall_center_sales_type();
											this.get_help_center_help_topics();
														this.get_member_center_user_name();
													this.get_member_center_member_id();
							this.get_member_center_customer_star_rating();
											this.get_promotion_management_promotion_name();
										this.get_promotion_management_promotional_products();
																							this.get_operation_management_operational_projects();
							this.get_operation_management_operational_objectives();
																this.get_operation_management_person_in_charge();
														this.get_financial_management_month();
																		  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_goods();
	  this.get_article();
							  this.get_ordinary_users_user_name();
													  this.get_mall_center_article_no();
						  this.get_mall_center_sales_type();
										  this.get_help_center_help_topics();
													  this.get_member_center_user_name();
												  this.get_member_center_member_id();
						  this.get_member_center_customer_star_rating();
										  this.get_promotion_management_promotion_name();
									  this.get_promotion_management_promotional_products();
																						  this.get_operation_management_operational_projects();
						  this.get_operation_management_operational_objectives();
															  this.get_operation_management_person_in_charge();
													  this.get_financial_management_month();
																			},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
