<template>
  <div>
    <table class="table">
      <thead>
        <tr>
          <th>Order ID</th>
          <th>Tanggal Pesanan</th>
          <th>Status</th>
          <th>Tindakan</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="datas in data" :key="datas.id">
          <td>{{ datas.id }}</td>
          <td>{{ datas.orderDate }}</td>
          <td>{{ datas.status }}</td>
          <td>
            <button @click="selectOrdersItem(datas)" class="btn btn-primary">
              Detail
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>

  <!-- <modal
    :show="showmodalSeeDetails"
    :orders="selectedOrder"
    @close="showmodalSeeDetails = false"
  /> -->

  <detailsOrderNew :show="showmodalSeeDetails" :orders="selectedOrder" />
</template>

<script>
import axios from "axios";
import detailsOrderNew from "../components/modals/detailsOrderNew.vue";
import modal from "../components/modals/DetailsOrder.vue";
import { mapGetters } from "vuex";

export default {
  components: { detailsOrderNew, modal },

  data() {
    return {
      data: [],
      showmodalSeeDetails: false,
      selectedOrder: null,
    };
  },

  computed: {
    ...mapGetters(["vendoruuid", "vendorid"]),
  },
  created() {
    axios
      .get(
        `http://rsudsamrat.site:8080/pengadaan/dev/v1/orders/${this.vendorid}/vendor`
      ) //getorderbyvendorid
      .then((response) => {
        this.data = response.data;
        console.log(response.data);
      })
      .catch((err) => {
        console.log(err);
      });
  },
  methods: {
    selectOrdersItem(order) {
      this.showmodalSeeDetails = true;
      this.selectedOrder = order;
    },
  },
};
</script>
