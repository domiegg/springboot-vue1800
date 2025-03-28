<template>
	<div class="diy_home diy_list diy_promotion_management" id="diy_promotion_management_list">
		<!-- 列表 -->
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods diy_list_box_wrap" v-for="(o, i) in list" :key="i"
				:to="'/promotion_management/details?promotion_management_id=' + o['promotion_management_id']">
				<!-- 图片 -->
				<div class="diy_list_img_box" v-if="imgList.length" >
					<div class="diy_row" v-for="(item,index) in imgList" :key="item+index" v-show="$check_field('get',item.name,'/promotion_management/details') && +item.is_img_list">
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
						<div class="diy_row" :class="{[item.name]:true}" v-if="$check_field('get',item.name,'/promotion_management/details') && +item.is_img_list">
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
						<th class="diy_title" v-if="$check_field('get','promotion_name')">
						促销名称
					</th>
							<th class="diy_title" v-if="$check_field('get','promotion_purpose')">
						促销目的
					</th>
							<th class="diy_title" v-if="$check_field('get','promotional_products')">
						促销商品
					</th>
							<th class="diy_title" v-if="$check_field('get','original_price')">
						原价
					</th>
							<th class="diy_title" v-if="$check_field('get','promotional_price')">
						促销价
					</th>
							<th class="diy_title" v-if="$check_field('get','start_date')">
						开始日期
					</th>
							<th class="diy_title" v-if="$check_field('get','promotion_end_date')">
						结束日期
					</th>
							</tr>
				<tr class="diy_row" v-for="(o,i) in list" :key="o+i">
						<td class="diy_field diy_text" v-if="$check_field('get','promotion_name')">
						<span>
							{{ o["promotion_name"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','promotion_purpose')">
						<span>
							{{ o["promotion_purpose"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','promotional_products')">
						<span>
							{{ o["promotional_products"] }}
						</span>
					</td>
							<td class="diy_field diy_number" v-if="$check_field('get','original_price')">
						<span>
							{{ o["original_price"] }}
						</span>
					</td>
							<td class="diy_field diy_number" v-if="$check_field('get','promotional_price')">
						<span>
							{{ o["promotional_price"] }}
						</span>
					</td>
							<td class="diy_field diy_date" v-if="$check_field('get','start_date')">
						<span>
							{{ $toTime(o["start_date"] ,"yyyy-MM-dd") }}
						</span>
					</td>
							<td class="diy_field diy_date" v-if="$check_field('get','promotion_end_date')">
						<span>
							{{ $toTime(o["promotion_end_date"] ,"yyyy-MM-dd") }}
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
									title: "促销名称",
									name: "promotion_name",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "促销目的",
									name: "promotion_purpose",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "促销商品",
									name: "promotional_products",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "原价",
									name: "original_price",
									type: "数字",
									is_img_list: "0"
								},
								{
									title: "促销价",
									name: "promotional_price",
									type: "数字",
									is_img_list: "0"
								},
								{
									title: "开始日期",
									name: "start_date",
									type: "日期",
									is_img_list: "0"
								},
								{
									title: "结束日期",
									name: "promotion_end_date",
									type: "日期",
									is_img_list: "0"
								},
						],
						richList: [
								{
									title: "促销效果",
									name: "promotion_effect",
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

