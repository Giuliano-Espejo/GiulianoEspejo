import Spinner from 'react-bootstrap/Spinner';

function Loader() {
    return (
        <div className='Loader'>
            <Spinner animation="border" variant='info' className='loader-spinner'>
            </Spinner>
        </div>
    );
}

export default Loader;