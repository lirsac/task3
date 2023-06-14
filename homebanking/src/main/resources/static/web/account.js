const urlParams = new URLSearchParams(window.location.search);
const accountId = urlParams.get('id');

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
            this.sortTransactions(); // Llama al método para ordenar las transacciones
          })
          .catch(error => {
            console.error(error);
          });
      },
      sortTransactions() {
        this.transactions.sort((a, b) => {
          const dateA = new Date(a.dateTime);
          const dateB = new Date(b.dateTime);
          return dateB - dateA; // Ordena en orden descendente (más reciente primero)
        });},
    getTransactionClass(transaction) {
      if (transaction.type === 'CREDIT') {
        return 'credit';
      } else {
        return 'debit';
      }
    },
    formatAmount(amount) {
      return Number(amount).toLocaleString('en-US', { style: 'currency', currency: 'USD' });
    },
    formatDate(date) {
      const formattedDate = new Date(date).toLocaleDateString('en-US', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
      });
      return formattedDate;
    },
    formatTime(date) {
      const formattedTime = new Date(date).toLocaleTimeString('en-US', {
        hour: 'numeric',
        minute: 'numeric',
        hour12: false
      });
      return formattedTime;
    }
  }
});
