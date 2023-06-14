var urlParams = new URLSearchParams(window.location.search);
var accountId = urlParams.get('id');

new Vue({
  el: '#transactionsTable',
  data: {
    transactions: []
  },
  mounted() {
    this.fetchAccountTransactions();
  },
  methods: {
    fetchAccountTransactions() {
      axios.get('/api/accounts/' + accountId)
        .then(response => {
          this.transactions = response.data.transactions;
        })
        .catch(error => {
          console.error(error);
        });
    },
    getTransactionClass(transaction) {
      if (transaction.type === 'CREDIT') {
        return 'credit';
      } else {
        return 'debit';
      }
    },
    formatAmount(amount) {
      return Number(amount).toLocaleString('en-US', { style: 'currency', currency: 'USD' });
    }
  }
});

