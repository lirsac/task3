var app = new Vue({
  el: '#app',
  data: {
    clientData: {
      firstName: '',
      lastName: '',
      email: ''
    },
    clients: [],
    responseData: ''
  },
  mounted() {
    this.loadData();
  },
  methods: {
    loadData() {
      axios
        .get('/clients')
        .then(response => {
          this.clients = response.data._embedded.clients;
          this.responseData = JSON.stringify(response.data, null, 2);
        })
        .catch(error => {
          console.log(error);
        });
    },
    addClient() {
      axios
        .post('/clients', this.clientData)
        .then(response => {
          this.clientData.firstName = '';
          this.clientData.lastName = '';
          this.clientData.email = '';
          this.loadData();
        })
        .catch(error => {
          console.log(error);
        });
    },
    deleteClient(client) {
      axios
        .delete(client._links.self.href)
        .then(response => {
          this.loadData();
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  filters: {
    prettyPrint: function (value) {
      if (!value) return '';
      return JSON.stringify(value, null, 2);
    }
  }
});
