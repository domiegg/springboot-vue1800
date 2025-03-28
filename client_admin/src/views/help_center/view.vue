<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','help_cover') || $check_field('add','help_cover') || $check_field('set','help_cover')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="帮助封面" prop="help_cover">
								<el-upload :disabled="disabledObj['help_cover_isDisabled']" id="help_cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_help_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['help_center_id'] && $check_field('set','help_cover')) || (!form['help_center_id'] && $check_field('add','help_cover'))">
						<img v-if="form['help_cover']" :src="$fullUrl(form['help_cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','help_cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['help_cover'])" :preview-src-list="[$fullUrl(form['help_cover'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','help_topics') || $check_field('add','help_topics') || $check_field('set','help_topics')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="帮助主题" prop="help_topics">
												<el-input id="help_topics" v-model="form['help_topics']" placeholder="请输入帮助主题"
							  v-if="user_group === '管理员' || (form['help_center_id'] && $check_field('set','help_topics')) || (!form['help_center_id'] && $check_field('add','help_topics'))" :disabled="disabledObj['help_topics_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','help_topics')">{{form['help_topics']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','help_details') || $check_field('add','help_details') || $check_field('set','help_details')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="帮助详情" prop="help_details">
					<quill-editor v-model.number="form['help_details']"
						v-if="user_group === '管理员' || (form['help_center_id'] && $check_field('set','help_details')) || (!form['help_center_id'] && $check_field('add','help_details')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','help_details')" v-html="form['help_details']"></div>
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
				field: "help_center_id",
				url_add: "~/api/help_center/add?",
				url_set: "~/api/help_center/set?",
				url_get_obj: "~/api/help_center/get_obj?",
				url_upload: "~/api/help_center/upload?",

				query: {
					"help_center_id": 0,
				},

				form: {
								"help_cover":  '', // 帮助封面
										"help_topics":  '', // 帮助主题
										"help_details":  '', // 帮助详情
											"help_center_id": 0, // ID
						
				},
				disabledObj:{
								"help_cover_isDisabled": false,
										"help_topics_isDisabled": false,
										"help_details_isDisabled": false,
										},

	
		
		
	
			}
		},
		methods: {


				/**
			 * 上传帮助封面
			 * @param {Object} param 图片参数
			 */
			upload_help_cover(param){
						this.uploadFile(param.file, "help_cover");
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
					bl = this.$check_action('/help_center/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/help_center/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/help_center/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/help_center/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/help_center/view','get');
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
