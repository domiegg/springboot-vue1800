<template>
	<div class="diy_home diy_list diy_operation_management" id="diy_operation_management_list">
		<!-- 列表 -->
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods diy_list_box_wrap" v-for="(o, i) in list" :key="i"
				:to="'/operation_management/details?operation_management_id=' + o['operation_management_id']">
				<!-- 图片 -->
				<div class="diy_list_img_box" v-if="imgList.length" >
					<div class="diy_row" v-for="(item,index) in imgList" :key="item+index" v-show="$check_field('get',item.name,'/operation_management/details') && +item.is_img_list">
						<div class="diy_title diy_list_img_title">
							<span>{{item.title}}:</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(o[item.name])" style="width:100%;height:100%" />
						</div>
					</div>
				</div>
				<!-- 内容 -->
				<div class="diy_list_item_box">
					<div class="diy_list_item_content" v-for="(item,index) in showItemList" :key="item+index">
						<div class="diy_row" :class="{[item.name]:true}" v-if="$check_field('get',item.name,'/operation_management/details') && +item.is_img_list">
							<div class="diy_title">
								<span>{{item.title}}:</span>
							</div>
							<div class="diy_field diy_text">
								<span v-if="item.type == 'UID'" v-text="get_user_name(item.name,o[item.name])"></span>
								<span v-else-if="item.type == '日期'" v-text="$toTime(o[item.name],'yyyy-MM-dd')"></span>
								<span v-else-if="item.type == '时间'" v-text="$toTime(o[item.name],'hh:mm:ss')"></span>
								<span v-else-if="item.type == '日长'" v-text="$toTime(o[item.name],'yyyy-MM-dd hh:mm:ss')"></span>
								<span v-else v-text="o[item.name]"></span>
							</div>
						</div>
					</div>
				</div>
			</router-link>
		</div>
		<!-- 表格 -->
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
						<th class="diy_title" v-if="$check_field('get','operational_projects')">
						运营项目
					</th>
							<th class="diy_title" v-if="$check_field('get','operational_objectives')">
						运营目标
					</th>
							<th class="diy_title" v-if="$check_field('get','staffing')">
						人员配置
					</th>
							<th class="diy_title" v-if="$check_field('get','start_date')">
						启动日期
					</th>
							<th class="diy_title" v-if="$check_field('get','end_date')">
						结束日期
					</th>
							<th class="diy_title" v-if="$check_field('get','person_in_charge')">
						负责人
					</th>
							<th class="diy_title" v-if="$check_field('get','operation_plan')">
						运营计划
					</th>
							</tr>
				<tr class="diy_row" v-for="(o,i) in list" :key="o+i">
						<td class="diy_field diy_text" v-if="$check_field('get','operational_projects')">
						<span>
							{{ o["operational_projects"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','operational_objectives')">
						<span>
							{{ o["operational_objectives"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','staffing')">
						<span>
							{{ o["staffing"] }}
						</span>
					</td>
							<td class="diy_field diy_date" v-if="$check_field('get','start_date')">
						<span>
							{{ $toTime(o["start_date"] ,"yyyy-MM-dd") }}
						</span>
					</td>
							<td class="diy_field diy_date" v-if="$check_field('get','end_date')">
						<span>
							{{ $toTime(o["end_date"] ,"yyyy-MM-dd") }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','person_in_charge')">
						<span>
							{{ o["person_in_charge"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','operation_plan')">
						<span>
							{{ o["operation_plan"] }}
						</span>
					</td>
							</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				},
			},
			show: {
				type: Boolean,
				default: function(){
					return true;
				}
			}
		},
		data() {
			return {
						imgList: [
						],
						itemList: [
								{
									title: "运营项目",
									name: "operational_projects",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "运营目标",
									name: "operational_objectives",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "人员配置",
									name: "staffing",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "启动日期",
									name: "start_date",
									type: "日期",
									is_img_list: "0"
								},
								{
									title: "结束日期",
									name: "end_date",
									type: "日期",
									is_img_list: "0"
								},
								{
									title: "负责人",
									name: "person_in_charge",
									type: "文本",
									is_img_list: "0"
								},
						],
						richList: [
								{
									title: "运营计划",
									name: "operation_plan",
									type: "多文本"
								},
								{
									title: "运营效果",
									name: "operational_effectiveness",
									type: "编辑"
								},
						],
											};
		},
		methods: {
			get_user_name(name,id){
				var obj = null;
												var ret = "";
				if(obj){
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
				}
				return ret;
			},
										},
		created() {
										},
		computed:{
			showItemList(){
				let arr = [];
				let _type = ["视频","音频","文件"];
				this.itemList.forEach(item => {
					if(_type.indexOf(item.type) === -1 && !!+item.is_img_list){
						arr.push(item)
					}
				})
				return arr.slice(0,4);
			}
		}
	};
</script>

<style scoped>
	.media {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		flex-basis: 75%;
		min-height: 10rem;
	}

	.goods {
		display: flex;
		width: calc(25% - 1rem);
		margin: 0.5rem;
		padding: 0.5rem;
		flex-direction: column;
		justify-content: space-between;
		background-color: white;
		border-radius: 0.5rem;
	}

	.goods:hover {
		border: 0.2rem solid #909399;
		box-shadow: 0 0.1rem 0.3rem rgba(0, 0, 0, 0.15);
	}

	.goods:hover img {
		filter: blur(1px);
	}

	.price {
		font-size: 1rem;
		margin-right: 3px;
	}

	.price_ago {
		text-decoration: line-through;
		font-size: 0.5rem;
		color: #999;

	}

	.title {
		word-break: break-all;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
		font-weight: 700;
		padding: .25rem;
	}

	.icon_cart {
		color: #FF5722;
		float: right;
	}

	@media (max-width: 992px) {

		.goods {
			width: calc(33% - 1rem);
			;
		}

	}

	@media (max-width: 768px) {

		.goods {
			width: calc(50% - 1rem);
			;
		}

	}
</style>

