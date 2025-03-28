<template>
	<el-form ref="form" :rules="rules" :model="form" status-icon label-width="80px">
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
			<el-form-item label="商品编号" prop="article_no">
						<el-input id="article_no" v-model="form['article_no']" placeholder="请输入商品编号"
					v-if="user_group == '管理员' || (form['mall_center_id'] && $check_field('set','article_no') ) || $check_field('add','article_no')"></el-input>
				<div v-else-if="$check_field('get','article_no')">{{form['article_no']}}</div>
					</el-form-item>
		</el-col>
				<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
			<el-form-item label="销售类型" prop="sales_type">
						<el-input id="sales_type" v-model="form['sales_type']" placeholder="请输入销售类型"
					v-if="user_group == '管理员' || (form['mall_center_id'] && $check_field('set','sales_type') ) || $check_field('add','sales_type')"></el-input>
				<div v-else-if="$check_field('get','sales_type')">{{form['sales_type']}}</div>
					</el-form-item>
		</el-col>
	
		<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
			<el-form-item label="点击数" prop="hits">
				<el-input-number id="hits" v-model="form['hits']"
					v-if="user_group == '管理员' || $check_field('set','hits')"></el-input-number>
				<div v-else-if="$check_field('get','hits')">{{form["hits"]}}</div>
			</el-form-item>
		</el-col>


		<el-col :xs="24" :sm="24" :lg="24" style="text-align: center;" class="el_form_btn_warp">
			<el-button type="primary" @click="submit()">提交</el-button>
			<el-button @click="cancel()">取消</el-button>
		</el-col>

	</el-form>
</template>

<script>
	import mixin from "../../mixins/component.js";

	export default {
		mixins: [mixin],
		props:{
			query: {
				type: Object,
				default: function(){
					return {
						"mall_center_id": 0
					}
				}
			},
			form_goods:{
				type: Object,
				default: function(){
					return {}
				}
			},
			func_check:{
				type: Function,
				default: function(fun){
					console.log("调试输出",fun);
				}
			},
			func_submit:{
				type: Function,
				default: function(fun){
					console.log("调试输出",fun);
				}
			}
		},
		data() {
			return {
				field: "mall_center_id",
				url_add: "~/api/mall_center/add?",
				url_set: "~/api/mall_center/set?",
				url_get_obj: "~/api/mall_center/get_obj?",
				url_upload: "~/api/mall_center/upload?",

				form: {
						"article_no":  '',
							"sales_type":  '',
						"hits": 0,
				},

		
				rules: {
					"article_no": [     {required: true,message: '商品编号不能为空'},  ],
					"sales_type": [     {required: true,message: '销售类型不能为空'},  ],
				}

			}
		},
		methods: {

			/**
			 * 请求列表前
			 * @param {Object} param
			 */
			get_list_before(param) {
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
												}
				}

				return param;
			},

	
	
		
	
	
			submit(){
				this.func_check(()=>{
					this.$refs["form"].validate((valid)} => {
						if (valid) {
							this.submit();
						} else {
							console.error('error 提交失败!!');
						}
					});
				})
			},

			submit_after(){
				var source_id = this.form_goods.source_id;
				if(source_id){
					this.func_submit();
				}else{
					this.$get('~/api/mall_center/get_obj?',this.form,(res)=>{
						if(res.result && res.result.obj){
							this.form_goods.source_id = res.result.obj["mall_center_id"];
							this.func_submit();
						}else{
							console.error(res.error);
						}

					})
				}
			}
		},
		created() {
				}
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
