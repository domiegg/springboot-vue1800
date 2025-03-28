<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','promotion_name') || $check_field('add','promotion_name') || $check_field('set','promotion_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="促销名称" prop="promotion_name">
												<el-input id="promotion_name" v-model="form['promotion_name']" placeholder="请输入促销名称"
							  v-if="user_group === '管理员' || (form['promotion_management_id'] && $check_field('set','promotion_name')) || (!form['promotion_management_id'] && $check_field('add','promotion_name'))" :disabled="disabledObj['promotion_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','promotion_name')">{{form['promotion_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','promotion_purpose') || $check_field('add','promotion_purpose') || $check_field('set','promotion_purpose')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="促销目的" prop="promotion_purpose">
												<el-input id="promotion_purpose" v-model="form['promotion_purpose']" placeholder="请输入促销目的"
							  v-if="user_group === '管理员' || (form['promotion_management_id'] && $check_field('set','promotion_purpose')) || (!form['promotion_management_id'] && $check_field('add','promotion_purpose'))" :disabled="disabledObj['promotion_purpose_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','promotion_purpose')">{{form['promotion_purpose']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','promotional_products') || $check_field('add','promotional_products') || $check_field('set','promotional_products')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="促销商品" prop="promotional_products">
												<el-input id="promotional_products" v-model="form['promotional_products']" placeholder="请输入促销商品"
							  v-if="user_group === '管理员' || (form['promotion_management_id'] && $check_field('set','promotional_products')) || (!form['promotion_management_id'] && $check_field('add','promotional_products'))" :disabled="disabledObj['promotional_products_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','promotional_products')">{{form['promotional_products']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','original_price') || $check_field('add','original_price') || $check_field('set','original_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="原价" prop="original_price">
								<el-input-number id="original_price" v-model.number="form['original_price']"
						v-if="user_group === '管理员' || (form['promotion_management_id'] && $check_field('set','original_price')) || (!form['promotion_management_id'] && $check_field('add','original_price'))" :disabled="disabledObj['original_price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','original_price')">{{form['original_price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','promotional_price') || $check_field('add','promotional_price') || $check_field('set','promotional_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="促销价" prop="promotional_price">
								<el-input-number id="promotional_price" v-model.number="form['promotional_price']"
						v-if="user_group === '管理员' || (form['promotion_management_id'] && $check_field('set','promotional_price')) || (!form['promotion_management_id'] && $check_field('add','promotional_price'))" :disabled="disabledObj['promotional_price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','promotional_price')">{{form['promotional_price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','start_date') || $check_field('add','start_date') || $check_field('set','start_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="开始日期" prop="start_date">
								<el-date-picker :disabled="disabledObj['start_date_isDisabled']" v-if="user_group === '管理员' || (form['promotion_management_id'] && $check_field('set','start_date')) || (!form['promotion_management_id'] && $check_field('add','start_date'))" id="start_date"
						v-model="form['start_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','start_date')">{{form['start_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','promotion_end_date') || $check_field('add','promotion_end_date') || $check_field('set','promotion_end_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="结束日期" prop="promotion_end_date">
								<el-date-picker :disabled="disabledObj['promotion_end_date_isDisabled']" v-if="user_group === '管理员' || (form['promotion_management_id'] && $check_field('set','promotion_end_date')) || (!form['promotion_management_id'] && $check_field('add','promotion_end_date'))" id="promotion_end_date"
						v-model="form['promotion_end_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','promotion_end_date')">{{form['promotion_end_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','promotion_effect') || $check_field('add','promotion_effect') || $check_field('set','promotion_effect')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="促销效果" prop="promotion_effect">
					<quill-editor v-model.number="form['promotion_effect']"
						v-if="user_group === '管理员' || (form['promotion_management_id'] && $check_field('set','promotion_effect')) || (!form['promotion_management_id'] && $check_field('add','promotion_effect')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','promotion_effect')" v-html="form['promotion_effect']"></div>
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
				field: "promotion_management_id",
				url_add: "~/api/promotion_management/add?",
				url_set: "~/api/promotion_management/set?",
				url_get_obj: "~/api/promotion_management/get_obj?",
				url_upload: "~/api/promotion_management/upload?",

				query: {
					"promotion_management_id": 0,
				},

				form: {
								"promotion_name":  '', // 促销名称
										"promotion_purpose":  '', // 促销目的
										"promotional_products":  '', // 促销商品
										"original_price":  0, // 原价
										"promotional_price":  0, // 促销价
										"start_date":  '', // 开始日期
										"promotion_end_date":  '', // 结束日期
										"promotion_effect":  '', // 促销效果
											"promotion_management_id": 0, // ID
						
				},
				disabledObj:{
								"promotion_name_isDisabled": false,
										"promotion_purpose_isDisabled": false,
										"promotional_products_isDisabled": false,
					          			"original_price_isDisabled": false,
					          			"promotional_price_isDisabled": false,
										"start_date_isDisabled": false,
										"promotion_end_date_isDisabled": false,
										"promotion_effect_isDisabled": false,
										},

	
		
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
		
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
												        if (this.form["start_date"].indexOf("-")===-1){
          this.form["start_date"] = this.$toTime(parseInt(this.form["start_date"]),"yyyy-MM-dd")
        }
			        if (this.form["promotion_end_date"].indexOf("-")===-1){
          this.form["promotion_end_date"] = this.$toTime(parseInt(this.form["promotion_end_date"]),"yyyy-MM-dd")
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


																	        if(this.form["start_date"]=="0000-00-00"){
          this.form["start_date"] = null;
        }
				if(parseInt(this.form["start_date"]) > 9999){
					this.form["start_date"] = this.$toTime(parseInt(this.form["start_date"]),"yyyy-MM-dd")
				}
				        if(this.form["promotion_end_date"]=="0000-00-00"){
          this.form["promotion_end_date"] = null;
        }
				if(parseInt(this.form["promotion_end_date"]) > 9999){
					this.form["promotion_end_date"] = this.$toTime(parseInt(this.form["promotion_end_date"]),"yyyy-MM-dd")
				}
					

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
					bl = this.$check_action('/promotion_management/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/promotion_management/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/promotion_management/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/promotion_management/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/promotion_management/view','get');
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
