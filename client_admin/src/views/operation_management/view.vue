<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','operational_projects') || $check_field('add','operational_projects') || $check_field('set','operational_projects')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="运营项目" prop="operational_projects">
												<el-input id="operational_projects" v-model="form['operational_projects']" placeholder="请输入运营项目"
							  v-if="user_group === '管理员' || (form['operation_management_id'] && $check_field('set','operational_projects')) || (!form['operation_management_id'] && $check_field('add','operational_projects'))" :disabled="disabledObj['operational_projects_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','operational_projects')">{{form['operational_projects']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','operational_objectives') || $check_field('add','operational_objectives') || $check_field('set','operational_objectives')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="运营目标" prop="operational_objectives">
												<el-input id="operational_objectives" v-model="form['operational_objectives']" placeholder="请输入运营目标"
							  v-if="user_group === '管理员' || (form['operation_management_id'] && $check_field('set','operational_objectives')) || (!form['operation_management_id'] && $check_field('add','operational_objectives'))" :disabled="disabledObj['operational_objectives_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','operational_objectives')">{{form['operational_objectives']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','staffing') || $check_field('add','staffing') || $check_field('set','staffing')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="人员配置" prop="staffing">
												<el-input id="staffing" v-model="form['staffing']" placeholder="请输入人员配置"
							  v-if="user_group === '管理员' || (form['operation_management_id'] && $check_field('set','staffing')) || (!form['operation_management_id'] && $check_field('add','staffing'))" :disabled="disabledObj['staffing_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','staffing')">{{form['staffing']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','start_date') || $check_field('add','start_date') || $check_field('set','start_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="启动日期" prop="start_date">
								<el-date-picker :disabled="disabledObj['start_date_isDisabled']" v-if="user_group === '管理员' || (form['operation_management_id'] && $check_field('set','start_date')) || (!form['operation_management_id'] && $check_field('add','start_date'))" id="start_date"
						v-model="form['start_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','start_date')">{{form['start_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','end_date') || $check_field('add','end_date') || $check_field('set','end_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="结束日期" prop="end_date">
								<el-date-picker :disabled="disabledObj['end_date_isDisabled']" v-if="user_group === '管理员' || (form['operation_management_id'] && $check_field('set','end_date')) || (!form['operation_management_id'] && $check_field('add','end_date'))" id="end_date"
						v-model="form['end_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','end_date')">{{form['end_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','person_in_charge') || $check_field('add','person_in_charge') || $check_field('set','person_in_charge')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="负责人" prop="person_in_charge">
												<el-input id="person_in_charge" v-model="form['person_in_charge']" placeholder="请输入负责人"
							  v-if="user_group === '管理员' || (form['operation_management_id'] && $check_field('set','person_in_charge')) || (!form['operation_management_id'] && $check_field('add','person_in_charge'))" :disabled="disabledObj['person_in_charge_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','person_in_charge')">{{form['person_in_charge']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','operation_plan') || $check_field('add','operation_plan') || $check_field('set','operation_plan')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="运营计划" prop="operation_plan">
								<el-input type="textarea" id="operation_plan" v-model="form['operation_plan']" placeholder="请输入运营计划"
						v-if="user_group === '管理员' || (form['operation_management_id'] && $check_field('set','operation_plan')) || (!form['operation_management_id'] && $check_field('add','operation_plan'))" :disabled="disabledObj['operation_plan_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','operation_plan')">{{form['operation_plan']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','operational_effectiveness') || $check_field('add','operational_effectiveness') || $check_field('set','operational_effectiveness')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="运营效果" prop="operational_effectiveness">
					<quill-editor v-model.number="form['operational_effectiveness']"
						v-if="user_group === '管理员' || (form['operation_management_id'] && $check_field('set','operational_effectiveness')) || (!form['operation_management_id'] && $check_field('add','operational_effectiveness')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','operational_effectiveness')" v-html="form['operational_effectiveness']"></div>
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
				field: "operation_management_id",
				url_add: "~/api/operation_management/add?",
				url_set: "~/api/operation_management/set?",
				url_get_obj: "~/api/operation_management/get_obj?",
				url_upload: "~/api/operation_management/upload?",

				query: {
					"operation_management_id": 0,
				},

				form: {
								"operational_projects":  '', // 运营项目
										"operational_objectives":  '', // 运营目标
										"staffing":  '', // 人员配置
										"start_date":  '', // 启动日期
										"end_date":  '', // 结束日期
										"person_in_charge":  '', // 负责人
										"operation_plan":  '', // 运营计划
										"operational_effectiveness":  '', // 运营效果
											"operation_management_id": 0, // ID
						
				},
				disabledObj:{
								"operational_projects_isDisabled": false,
										"operational_objectives_isDisabled": false,
										"staffing_isDisabled": false,
										"start_date_isDisabled": false,
										"end_date_isDisabled": false,
										"person_in_charge_isDisabled": false,
										"operation_plan_isDisabled": false,
										"operational_effectiveness_isDisabled": false,
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
			        if (this.form["end_date"].indexOf("-")===-1){
          this.form["end_date"] = this.$toTime(parseInt(this.form["end_date"]),"yyyy-MM-dd")
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
				        if(this.form["end_date"]=="0000-00-00"){
          this.form["end_date"] = null;
        }
				if(parseInt(this.form["end_date"]) > 9999){
					this.form["end_date"] = this.$toTime(parseInt(this.form["end_date"]),"yyyy-MM-dd")
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
					bl = this.$check_action('/operation_management/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/operation_management/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/operation_management/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/operation_management/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/operation_management/view','get');
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
