var app = new Vue({
  el: '#app',
  data: {
    client: {},
    accounts: []
  },
  mounted() {
    this.fetchClientData();
  },
  methods: {
    fetchClientData() {
      axios
        .get('/api/clients/1') // Cambia el ID del cliente según tus necesidades
        .then(response => {
          this.client = response.data;
          this.accounts = response.data.accounts.sort((a, b) => a.number.localeCompare(b.number));
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
});
