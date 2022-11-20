import DashBoard from "./components/DashBoard";

const App = () => {
  const deliveries = [
    {
      id: 'rider1',
      name: '김길동',
      status: '배송전',
      statusColor: 'indigo'
    },
    {
      id: 'rider2',
      name: '고길동',
      status: '배송전',
      statusColor: 'indigo'
    },
    {
      id: 'rider3',
      name: '홍길동',
      status: '배송전',
      statusColor: 'indigo'
    }

  ];

  return <DashBoard items={deliveries} />
}

export default App;
