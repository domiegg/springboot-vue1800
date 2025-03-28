<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','month') || $check_field('add','month') || $check_field('set','month')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="月份" prop="month">
												<el-input id="month" v-model="form['month']" placeholder="请输入月份"
							  v-if="user_group === '管理员' || (form['financial_management_id'] && $check_field('set','month')) || (!form['financial_management_id'] && $check_field('add','month'))" :disabled="disabledObj['month_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','month')">{{form['month']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','sales_volume') || $check_field('add','sales_volume') || $check_field('set','sales_volume')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="销售额" prop="sales_volume">
								<el-input-number id="sales_volume" v-model.number="form['sales_volume']"
						v-if="user_group === '管理员' || (form['financial_management_id'] && $check_field('set','sales_volume')) || (!form['financial_management_id'] && $check_field('add','sales_volume'))" :disabled="disabledObj['sales_volume_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','sales_volume')">{{form['sales_volume']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','product_cost') || $check_field('add','product_cost') || $check_field('set','product_cost')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="产品成本" prop="product_cost">
								<el-input-number id="product_cost" v-model.number="form['product_cost']"
						v-if="user_group === '管理员' || (form['financial_management_id'] && $check_field('set','product_cost')) || (!form['financial_management_id'] && $check_field('add','product_cost'))" :disabled="disabledObj['product_cost_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','product_cost')">{{form['product_cost']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','employee_salaries') || $check_field('add','employee_salaries') || $check_field('set','employee_salaries')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="员工工资" prop="employee_salaries">
								<el-input-number id="employee_salaries" v-model.number="form['employee_salaries']"
						v-if="user_group === '管理员' || (form['financial_management_id'] && $check_field('set','employee_salaries')) || (!form['financial_management_id'] && $check_field('add','employee_salaries'))" :disabled="disabledObj['employee_salaries_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','employee_salaries')">{{form['employee_salaries']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','other_expenses') || $check_field('add','other_expenses') || $check_field('set','other_expenses')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="其他支出" prop="other_expenses">
								<el-input-number id="other_expenses" v-model.number="form['other_expenses']"
						v-if="user_group === '管理员' || (form['financial_management_id'] && $check_field('set','other_expenses')) || (!form['financial_management_id'] && $check_field('add','other_expenses'))" :disabled="disabledObj['other_expenses_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','other_expenses')">{{form['other_expenses']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','profit') || $check_field('add','profit') || $check_field('set','profit')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="利润" prop="profit">
												<el-input id="profit" v-model="form['profit']" placeholder="请输入利润"
							  v-if="user_group === '管理员' || (form['financial_management_id'] && $check_field('set','profit')) || (!form['financial_management_id'] && $check_field('add','profit'))"  @focus="set_profit()" :disabled="disabledObj['profit_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','profit')">{{form['profit']}}</div>
											</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "financial_management_id",
				url_add: "~/api/financial_management/add?",
				url_set: "~/api/financial_management/set?",
				url_get_obj: "~/api/financial_management/get_obj?",
				url_upload: "~/api/financial_management/upload?",

				query: {
					"financial_management_id": 0,
				},

				form: {
								"month":  '', // 月份
										"sales_volume":  0, // 销售额
										"product_cost":  0, // 产品成本
										"employee_salaries":  0, // 员工工资
										"other_expenses":  0, // 其他支出
										"profit":  '', // 利润
											"financial_management_id": 0, // ID
						
				},
				disabledObj:{
								"month_isDisabled": false,
					          			"sales_volume_isDisabled": false,
					          			"product_cost_isDisabled": false,
					          			"employee_salaries_isDisabled": false,
					          			"other_expenses_isDisabled": false,
										"profit_isDisabled": false,
										},

	
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
	
										set_profit(){
				this.form.profit = parseFloat(this.form.sales_volume) - parseFloat(this.form.product_cost) - parseFloat(this.form.employee_salaries) - parseFloat(this.form.other_expenses)
			},
						
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
							
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																		

			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																								return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/financial_management/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/financial_management/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/financial_management/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/financial_management/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/financial_management/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
														},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
