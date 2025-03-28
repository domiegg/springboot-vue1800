<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','user_account') || $check_field('add','user_account') || $check_field('set','user_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户账号" prop="user_account">
													<el-select v-if="user_group === '管理员' || (form['member_center_id'] && $check_field('set','user_account')) || (!form['member_center_id'] && $check_field('add','user_account'))" id="user_account" v-model="form['user_account']" :disabled="disabledObj['user_account_isDisabled']">
							<el-option v-for="o in list_user_user_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','user_account')" id="user_account" v-model="form['user_account']" :disabled="true">
							<el-option v-for="o in list_user_user_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户姓名" prop="user_name">
												<el-input id="user_name" v-model="form['user_name']" placeholder="请输入用户姓名"
							  v-if="user_group === '管理员' || (form['member_center_id'] && $check_field('set','user_name')) || (!form['member_center_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','gender') || $check_field('add','gender') || $check_field('set','gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="性别" prop="gender">
								<el-select id="gender" v-model="form['gender']"
						v-if="user_group === '管理员' || (form['member_center_id'] && $check_field('set','gender')) || (!form['member_center_id'] && $check_field('add','gender'))">
						<el-option v-for="o in list_gender" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','gender')">{{form['gender']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','age') || $check_field('add','age') || $check_field('set','age')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年龄" prop="age">
												<el-input id="age" v-model="form['age']" placeholder="请输入年龄"
							  v-if="user_group === '管理员' || (form['member_center_id'] && $check_field('set','age')) || (!form['member_center_id'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','age')">{{form['age']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','member_id') || $check_field('add','member_id') || $check_field('set','member_id')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="会员号" prop="member_id">
												<el-input id="member_id" v-model="form['member_id']" placeholder="请输入会员号"
							  v-if="user_group === '管理员' || (form['member_center_id'] && $check_field('set','member_id')) || (!form['member_center_id'] && $check_field('add','member_id'))" :disabled="disabledObj['member_id_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','member_id')">{{form['member_id']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','customer_star_rating') || $check_field('add','customer_star_rating') || $check_field('set','customer_star_rating')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="客户星级" prop="customer_star_rating">
								<el-select id="customer_star_rating" v-model="form['customer_star_rating']"
						v-if="user_group === '管理员' || (form['member_center_id'] && $check_field('set','customer_star_rating')) || (!form['member_center_id'] && $check_field('add','customer_star_rating'))">
						<el-option v-for="o in list_customer_star_rating" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','customer_star_rating')">{{form['customer_star_rating']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','remarks') || $check_field('add','remarks') || $check_field('set','remarks')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="备注" prop="remarks">
					<quill-editor v-model.number="form['remarks']"
						v-if="user_group === '管理员' || (form['member_center_id'] && $check_field('set','remarks')) || (!form['member_center_id'] && $check_field('add','remarks')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','remarks')" v-html="form['remarks']"></div>
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
				field: "member_center_id",
				url_add: "~/api/member_center/add?",
				url_set: "~/api/member_center/set?",
				url_get_obj: "~/api/member_center/get_obj?",
				url_upload: "~/api/member_center/upload?",

				query: {
					"member_center_id": 0,
				},

				form: {
								"user_account": 0, // 用户账号
										"user_name":  '', // 用户姓名
										"gender":  '', // 性别
										"age":  '', // 年龄
										"member_id":  '', // 会员号
										"customer_star_rating":  '', // 客户星级
										"remarks":  '', // 备注
											"member_center_id": 0, // ID
						
				},
				disabledObj:{
								"user_account_isDisabled": false,
										"user_name_isDisabled": false,
										"gender_isDisabled": false,
										"age_isDisabled": false,
										"member_id_isDisabled": false,
										"customer_star_rating_isDisabled": false,
										"remarks_isDisabled": false,
										},

	
					// 用户列表
				list_user_user_account: [],
				
						// 性别选项列表
				list_gender: ['男','女'],
	
		
		
						// 客户星级选项列表
				list_customer_star_rating: ['一星','二星','三星'],
	
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_user_account() {
                // if(this.user_group !== "管理员" && this.form["user_account"] === 0) {
                //     this.form["user_account"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=普通用户");
                if(json.result && json.result.list){
                    this.list_user_user_account = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_user_account(id){
				var obj = this.list_user_user_account.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
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
					bl = this.$check_action('/member_center/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/member_center/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/member_center/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/member_center/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/member_center/view','get');
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
					this.get_list_user_user_account();
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
